package com.project.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.dto.User;
import com.project.foodapp.service.FoodAppService;

@RestController
public class UserController {

	@Autowired
	FoodAppService service;

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
}
