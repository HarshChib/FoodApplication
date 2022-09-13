package com.project.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
@Autowired
FoodOrderRepository repository;
	public FoodOrder addOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		return repository.save(order);
	}
	public FoodOrder updateOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		return repository.save(order);
	}
	public FoodOrder getOrderById(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}
	public String deleteOrder(int id) {
		// TODO Auto-generated method stub
		FoodOrder order=getOrderById(id);
		if(order!=null) {
			repository.delete(order);
			return order.getCustomerName()+   "the order is deleted";
		}else {
			return"No order is deleted";
		}
	}
	
	

	
}
