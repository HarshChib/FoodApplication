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

import com.project.foodapp.dto.EmailDetails;
import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.dto.User;
import com.project.foodapp.service.EmailService;
import com.project.foodapp.service.EmailServiceImpl;
import com.project.foodapp.service.FoodOrderService;
import com.project.foodapp.service.UserService;

@RestController
public class FoodOrderController {
    @Autowired
	FoodOrderService service;
	
    @Autowired
    UserService userService;
    
    @Autowired
    private EmailServiceImpl emailService;
    
	@PostMapping("/addOrder/{user_id}")
	public FoodOrder addOrder(@RequestBody FoodOrder order,@PathVariable int user_id) {
		User user = userService.getUserById(user_id);
		order.setUser(user);
		return service.addOrder(order);
	}
	
	@PutMapping("/updateorder/{user_id}")
	public FoodOrder updateOrder(@RequestBody FoodOrder order,@PathVariable int user_id) {
		FoodOrder updated_order=service.updateOrder(order);;
		User user=userService.getUserById(user_id);
		EmailDetails details=new EmailDetails();
		details.setRecipient(user.getEmail());
		details.setMsgBody(updated_order.toString());
		details.setSubject("Order finalized for Customer with name : "+updated_order.getCustomerName());
		System.out.println(emailService.sendSimpleMail(details));
		return updated_order;
	}
	
	@GetMapping("/order/{id}")
	public List<FoodOrder> getOrderById(@PathVariable("id")  int id) {
		User user=userService.getUserById(id);
		return user.getFoodOrders();

	}
	
	@DeleteMapping("/delete/order/{user_id}")
	public String deleteOrder(@PathVariable("user_id") int user_id) {
		return service.deleteOrder(user_id);
	}
	
	@GetMapping("getorderbyid/{order_id}")
	public FoodOrder getOrderByOrderId(@PathVariable("order_id") int order_id) {
		return service.getFoodOrderById(order_id);
	}
	
	
}
