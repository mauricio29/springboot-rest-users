package com.example.app_rest_users.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
