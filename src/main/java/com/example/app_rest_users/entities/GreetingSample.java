package com.example.app_rest_users.entities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingSample {

	@GetMapping("/hello")
	String sayHello() {
		return "Hello !";
	}

}
