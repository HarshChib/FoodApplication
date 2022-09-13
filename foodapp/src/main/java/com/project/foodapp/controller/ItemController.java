
package com.project.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.dto.Item;
import com.project.foodapp.service.FoodAppService;

@RestController
public class ItemController {

	@Autowired
	FoodAppService service;

	@PostMapping("/additem")
	public Item addItem(@RequestBody Item item) {
		return service.addItem(item);
	}

	@DeleteMapping("/deleteitem/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		service.deleteItem(id);
		return "Deleted User with Id : "+id;
	}

	@PutMapping("/updateitem")
	public Item updateItem(@RequestBody Item item) {
		return service.updateItem(item);
	}

	@GetMapping("/getitems")
	public List<Item> getItems() {
		return service.getItems();
	}
}
