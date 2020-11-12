package com.example.app_rest_users.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

// TODO WIP - sample code

//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface UserRepository extends JpaRepository<User, Long> {
@Component
public class UserRepository {

	public List<User> findAll() {
		List<User> aux = new ArrayList<User>();
		aux.add(new User(1l));
		aux.add(new User(2l));
		return aux;
	}

}
