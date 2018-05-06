package com.free.shiro.service;

import java.util.List;

import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.User;

public interface UserService {

	public void insertUser(User user);

	public List<User> selectAllUsers();

	void deleteUser(String id);

	public void updateUser(User user);

	public Pager selectUser(Pager pager);
	
}
