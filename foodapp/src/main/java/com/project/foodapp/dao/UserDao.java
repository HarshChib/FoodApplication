package com.project.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.User;
import com.project.foodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;
	public User addUser(User user) {
		
		return repository.save(user);
	}

}
