package com.project.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.service.FoodAppService;

@RestController
public class FoodOrderController {
    @Autowired
	FoodAppService service;
	
	@PostMapping("/addOrder")
	public FoodOrder addOrder(@RequestBody FoodOrder order) {
		return service.addOrder(order);
	}
	
	@PutMapping("/update")
	public FoodOrder updateOrder(@RequestBody FoodOrder order) {
		return service.updateOrder(order);
	}
	
	@GetMapping("/order/{id}")
	public FoodOrder getOrderById(@PathVariable("id")  int id) {
		return service.getOrderById(id);
	}
	
	@DeleteMapping("/delete/order/{id}")
	public String deleteOrder(@PathVariable("id") int id) {
		return service.deleteOrder(id);
	}
	
	
	
}
