package com.project.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		service.deleteUser(id);
		return "Deleted User with Id : "+id;
	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@GetMapping("/getusers")
	public List<User> getUsers() {
		return service.getUsers();
	}

}
