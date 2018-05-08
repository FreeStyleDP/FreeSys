package com.free.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.exception.BusinessException;
import com.free.shiro.dao.UserRoleMapper;
import com.free.shiro.entity.DO.UserRole;
import com.free.shiro.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	public UserRoleMapper userRoleMapper;
	
	@Override
	public void insertUserRole(UserRole userRole) {
		int insert = userRoleMapper.insert(userRole);
		if (insert != 1) {
			throw new BusinessException("插入用户角色关系失败");
		}
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		int result = userRoleMapper.deleteUserRole( userRole);
		if(result != 1) {
			throw new  BusinessException("删除用户角色关系失败");
		}
	}

	@Override
	public List<UserRole> selectUserRoleByUserId(String userId) {
		List<UserRole> selectByUserId = userRoleMapper.selectByUserId(userId);
		return selectByUserId;
	}

}
