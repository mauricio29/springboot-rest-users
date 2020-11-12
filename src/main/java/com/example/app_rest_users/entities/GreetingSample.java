package com.example.app_rest_users.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class GreetingSample {

	@Autowired
	UserRepository repository;

	@GetMapping("/hello")
	String sayHello() {
		return "Hello !";
	}

	@GetMapping("/init")
	String initH2Database() {
		repository.save(new User("John", "john@srv.com", "pass_1"));
		repository.save(new User("Carla", "carla@srv.com", "pass_2"));
		repository.save(new User("Paul", "paul@srv.com", "pass_3"));
		return "Init Ok";
	}

	@GetMapping("/deleteAll")
	String clearDatabase() {
		repository.deleteAllInBatch();
		return "Delete Ok";
	}

}
