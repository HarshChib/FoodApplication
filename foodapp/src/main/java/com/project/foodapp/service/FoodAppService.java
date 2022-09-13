package com.project.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.UserDao;
import com.project.foodapp.dto.FoodProduct;
import com.project.foodapp.dto.User;
import com.project.foodapp.dao.FoodProductDao;

@Service
public class FoodAppService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	FoodProductDao foodProductDao;

	public User addUser(User user) {
		
		return userDao.addUser(user);
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

}
