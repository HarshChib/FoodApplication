package com.project.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.User;
import com.project.foodapp.repository.UserRepository;

@Repository
public class UserDao {


	@Autowired
	UserRepository repository;
	public User addUser(User user) {
		String password=user.getPassword();
		String saltvalue = PassBasedEnc.getSaltvalue(30);
		String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue);
		password=saltvalue+encryptedpassword;
		user.setPassword(password);
		user.setEmail(user.getEmail().toLowerCase());
		return repository.save(user);
	}
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		System.out.println("User Deleted with id :" +id);
	}
	
	public User updateUser(User updated_user, int id) {
		// TODO Auto-generated method stub
		String password=updated_user.getPassword();
		String saltvalue = PassBasedEnc.getSaltvalue(30);
		String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue);
		password=saltvalue+encryptedpassword;
		User user=getUserById(id);
		user.setPassword(password);
		user.setName(updated_user.getName());
		if(updated_user.getRole()!=null)
			user.setRole(updated_user.getRole());
		return repository.save(user);
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	
	public User getByEmail(String email) {
		return repository.getByEmail(email);
	}
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		User existing=getByEmail(user.getEmail().toLowerCase());
		if(existing==null)
			return existing;
		if(PassBasedEnc.verifyUserPassword(user.getPassword(),existing.getPassword().substring(30),existing.getPassword().substring(0,30)))
			return existing;
		return null;
	}
	public User updateByManager(int user_id, String role) {
		// TODO Auto-generated method stub
		User user=getUserById(user_id);
		user.setRole(role);
		return repository.save(user);
	}
}
