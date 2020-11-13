package com.example.app_rest_users.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/check")
@Slf4j
public class GreetingSample {

	@Autowired
	UserController controller;

	@Autowired
	UserRepository repository;
	
	@GetMapping("/hello")
	String sayHello() {
		return "Hello !";
	}

	@GetMapping("/init")
	String initH2Database() throws Exception {
		log.debug("Adding sample data to database");
		controller.save(new User("John", "john@srv.com", "pass_1"));
		controller.save(new User("Carla", "carla@srv.com", "pass_2"));
		controller.save(new User("Paul", "paul@srv.com", "pass_3"));
		return "Init Ok";
	}

	@GetMapping("/deleteAll")
	String clearDatabase() {
		log.debug("Removing all USERS from database");
		repository.deleteAllInBatch();
		return "Delete Ok";
	}

}
