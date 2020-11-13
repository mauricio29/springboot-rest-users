package com.example.app_rest_users.rest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	public User(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String phone; // TODO: object

	private Date created;
	private Date modified;
	@JsonAlias(value = "last_login")
	private Date lastLogin;

	@JsonAlias(value = "is_active")
	private Boolean isActive = true;

	// TODO
	// private String token;
}
