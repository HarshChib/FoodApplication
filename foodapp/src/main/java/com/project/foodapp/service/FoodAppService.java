package com.project.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.FoodOrderDao;
import com.project.foodapp.dao.UserDao;
import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.dto.User;

@Service
public class FoodAppService {

	@Autowired
	UserDao userDao;
	@Autowired
	FoodOrderDao orderDao;
	

	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

	public FoodOrder addOrder(FoodOrder order) {
		return orderDao.addOrder(order);
	}

	public FoodOrder updateOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(order);
	}

	public FoodOrder getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(id);
	}

	public String deleteOrder(int id) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(id);
	}
}

	
