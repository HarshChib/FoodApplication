package com.project.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.foodapp.dao.FoodOrderDao;
import com.project.foodapp.dao.UserDao;
import com.project.foodapp.dto.FoodOrder;

import com.project.foodapp.dao.ItemDao;
import com.project.foodapp.dao.UserDao;

import com.project.foodapp.dto.FoodProduct;

import com.project.foodapp.dto.Item;

import com.project.foodapp.dto.User;
import com.project.foodapp.dao.FoodProductDao;

@Service
public class FoodAppService {

	@Autowired
	UserDao userDao;
	@Autowired
	FoodOrderDao orderDao;
	

	
	@Autowired
	FoodProductDao foodProductDao;
	@Autowired
	ItemDao itemDao;

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


	public FoodProduct addProduct(FoodProduct product) {
		return foodProductDao.addProduct(product);
	}

	public void deleteProduct(int id) {
		 foodProductDao.deleteProduct(id);
	}
	

	public List<FoodProduct> getProduct() {
		return foodProductDao.getProduct();
	}

	public FoodProduct updateProduct(FoodProduct product) {
		return foodProductDao.updateProduct(product);
	}


	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemDao.getItems();
	}

	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return itemDao.updateItem(item);
	}

	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		itemDao.deleteItem(id);
	}

	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		return itemDao.addItem(item);
	}


}

	
