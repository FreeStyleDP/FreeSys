package com.free.service;

import java.util.List;

import com.free.entity.DO.User;

public interface UserService {

	public void insertUser(User user);

	public List<User> selectAllUsers();
	
}
