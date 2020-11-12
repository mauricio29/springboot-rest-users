package com.example.app_rest_users.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;

	@GetMapping("/users")
	List<User> findAll() {
		return repo.findAll();
	}

}
