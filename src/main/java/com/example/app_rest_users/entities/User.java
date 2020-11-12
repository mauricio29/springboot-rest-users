package com.example.app_rest_users.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
