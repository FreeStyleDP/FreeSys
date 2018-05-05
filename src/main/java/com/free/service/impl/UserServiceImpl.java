package com.free.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.dao.UserMapper;
import com.free.entity.DO.User;
import com.free.exception.BusinessException;
import com.free.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public void insertUser(User user) {
		int insert = userMapper.insert(user);
		if(insert != 1) {
			throw new BusinessException("数据插入失败");
		}
	}

	@Override
	public List<User> selectAllUsers() {
		return userMapper.selectAll();
	}

}
