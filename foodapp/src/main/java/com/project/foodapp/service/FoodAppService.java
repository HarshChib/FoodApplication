package com.project.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.UserDao;
import com.project.foodapp.dto.User;

@Service
public class FoodAppService {

	@Autowired
	UserDao userDao;

	public User addUser(User user) {
		
		return userDao.addUser(user);
	}
}
