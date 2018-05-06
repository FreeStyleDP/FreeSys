package com.free.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.entity.DTO.Pager;
import com.free.exception.BusinessException;
import com.free.shiro.dao.UserMapper;
import com.free.shiro.entity.DO.User;
import com.free.shiro.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

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

	@Override
	public void deleteUser(String id) {
		int deleteByPrimaryKey = userMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey != 1) {
			throw new BusinessException("删除失败");
		}
	}

	@Override
	public void updateUser(User user) {
		int updateByPrimaryKey = userMapper.updateByPrimaryKey(user);
		if (updateByPrimaryKey != 1) {
			throw new BusinessException("修改失败");
			
		}
	}

	@Override
	public Pager selectUser(Pager pager) {
		PageHelper.startPage(pager.getCurrentPage(), pager.getPageSize());
		
		List<User> selectAll = userMapper.selectAll();
		pager.setContent(selectAll);
		
		PageInfo<User> pageInfo = new PageInfo<>(selectAll);
		pager.setRecordTotal((int)pageInfo.getTotal());
		return pager;
	}

}
