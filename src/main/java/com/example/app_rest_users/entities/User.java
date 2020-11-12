package com.example.app_rest_users.entities;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

import lombok.Data;

//@Data
//@Entity
public class User {

//	@Id
//	@GeneratedValue
	private Long id;

	private String name;
	private String email;
	private String password;
	private String phone; // TODO: object

}
