package com.crudapp.main.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.crudapp.main.model.User;

@Service
public class UserserviceImplementation implements UserService {

	Map<String, User> users;
	
	@Override
	public Collection<User> getUsers() {
		return users.values();
	}
	
	
	@Override
	public User createUser(User user) {
		
		User createdUser = new User();
		createdUser.setUserName(user.getUserName());
		createdUser.setPassword(user.getPassword());
		createdUser.setEmail(user.getEmail());
		String userId = UUID.randomUUID().toString();
		createdUser.setUserId(userId);
		
		if (users == null) {
			users = new HashMap<>();
		}
		users.put(userId, createdUser);
		return createdUser;
	}
	
	@Override
	public User getUser(String userId) {
		return users.get(userId);
	}

	@Override
	public User updateUser(String userId, User user) {
		User userFromDatabase = users.get(userId);
		userFromDatabase.setUserName(user.getUserName());
		userFromDatabase.setPassword(user.getPassword());
		userFromDatabase.setEmail(user.getEmail());
		return userFromDatabase;
	}

	@Override
	public void deleteUser(String userId) {
		users.remove(userId);
	}	
	
}