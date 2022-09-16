package com.project.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.dto.Item;
import com.project.foodapp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	@Autowired
	FoodOrderRepository repository;

	public FoodOrder addOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		order.setOrderCreatedTime(new java.util.Date() + "");
		return repository.save(order);
	}

	public FoodOrder updateOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		FoodOrder foodOrder = getOrderById(order.getId());
		int total = 0;
		for (Item i : foodOrder.getItems()) {
			total += (i.getPrice()*i.getQuantity());
		}
		foodOrder.setTotalPrice(total);
		foodOrder.setOrderDeliveryTime(new java.util.Date() + "");
		foodOrder.setStatus(order.isStatus());
		return repository.save(foodOrder);
	}

	public FoodOrder getOrderById(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	public String deleteOrder(int id) {
		// TODO Auto-generated method stub
		FoodOrder order = getOrderById(id);
		if (order != null) {
			repository.delete(order);
			return order.getCustomerName() + "the order is deleted";
		} else {
			return "No order is deleted";
		}
	}

	public FoodOrder getFoodOrderById(int foodorder_id) {
		// TODO Auto-generated method stub
		return repository.getById(foodorder_id);
	}

}
