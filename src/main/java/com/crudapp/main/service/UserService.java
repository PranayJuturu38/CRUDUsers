package com.crudapp.main.service;

import java.util.Collection;

import com.crudapp.main.model.User;

public interface UserService {
	User createUser(User user);
	
	Collection<User> getUsers();
	
    User getUser(String userId);
	
	User updateUser(String userId, User user);
	
	void deleteUser(String userId);
}