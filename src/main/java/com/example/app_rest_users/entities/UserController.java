package com.example.app_rest_users.entities;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;

	/** GET - List all Users. */
	@GetMapping("/users")
	List<User> findAll() {
		return repo.findAll();
	}

	/** GET	- Find user with given id. */
	@GetMapping("/users/{id}")
	User findOne(@PathVariable Long id) {
		return repo.findById(id).get();
	}

	/** POST - Save a User */
	@PostMapping("/users")
	void save(@RequestBody User newUser) {
		// TODO agregar validaciones ? 
		// por ejemplo : que si existe usuario con mismo correo por ejemplo, sino repite data
		
		Date currentTime = new Date(System.currentTimeMillis());
		newUser.setCreated(currentTime);
		newUser.setLastLogin(currentTime);
		repo.save(newUser);
	}

	/** PUT	- Update user with given id, or save it. */
	@PutMapping("/users/{id}")
	User saveOrUpdate(@RequestBody User user, @PathVariable Long id) throws Exception {
		// TODO MID : después de leer un KILO:
		// - recurso debe estar completo tal cual se obtiene con mismo URI en GET
		// - puedo retornar 204 (no-content), SIN body confirmando así escritura OK
		// - puedo retornar body, tal cual con GET
		// - puedo retornar 409, si falla alguna validación, dando mensaje bien explanatorio
		//                       por ejemplo si el ID es inválido
		// - puedo retornar 415, si hay algún error de content-type (raro)
		// - puedo retornar 201 (created), si recurso no existía
		// - puedo retornar 200 (ok), si 1) se modificó respuesta, 2) se modificó recurso
		// 								recurso debe ser modificado tal cual el body recibido, o 
		// 								el body retornado debe ser modificado tal cual el recurso almacenado
		
		if (user.getId() == null) {
			// si es null, lo permito y se modificaría resultado después de guardar
			user.setId(id);
			
		} else if (!user.getId().equals(id)) {
			// si son diferentes, conflicto 409 - TODO
			throw new Exception("TODO 409: Conflicto en campo ID");
		} 
		
		Optional<User> result = repo.findById(id);
		if (!result.isPresent()) {
			// Si no existe, una opción sería crearlo ... pero depende del servicio subyacente
//			System.out.println("NOT present - TODO : retornar 201 created \n\n"); // TODO 201 Created
//			return repo.save(user);
			// En este caso el servicio no permite almacenar identificador de usuario, 
			// por lo que debo retornar un conflicto
			throw new Exception("TODO 409: Servicio no permite crear con identificador arbitrario ");
		} else {
			System.out.println("present\n\n"); // TODO : logs

			User userPresent = result.get();
			userPresent.setName(user.getName());
			userPresent.setEmail(user.getEmail());
			userPresent.setPassword(user.getPassword());
			userPresent.setPhone(user.getPhone());
			
			userPresent.setIsActive(user.getIsActive());
			userPresent.setModified(new Date(System.currentTimeMillis()));

			return repo.save(userPresent); // retornar 200 OK ( o void 204, no-content)
		}
	}

	/** PATCH - Update some user fields with given id. */
	@PatchMapping("/users/{id}")
	User updateField(@RequestBody Map<String, String> updateMap, @PathVariable Long id) throws Exception {

		Optional<User> result = repo.findById(id);
		
		// TODO validate or not ? - if id != updateMap.get("id") -> error
		// check if fields not suported by patch by present in resurce should be validated
		
		if (result.isPresent()) {
			User patchUser = null;
			
			patchUser = result.get();
			
			// better : custom method to update a values
			String nameValue = updateMap.get("name");
			if (StringUtils.hasText(nameValue)) {
				patchUser.setName(nameValue);
			} else {
				throw new Exception("TODO error 4xx - campos no matchean");
			}
			
			// TODO more fields
			// ...

			patchUser.setModified(new Date(System.currentTimeMillis()));

			return repo.save(patchUser);
		} else {
			throw new Exception("TODO error XXX - NOT FOUND");
		}
	}

	/** DELETE - Delete user with given id. */
	@DeleteMapping("/users/{id}")
	void delete (@PathVariable Long id) {
		repo.deleteById(id);
	}

}
