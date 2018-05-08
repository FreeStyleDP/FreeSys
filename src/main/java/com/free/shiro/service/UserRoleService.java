package com.free.shiro.service;

import java.util.List;

import com.free.shiro.entity.DO.UserRole;

public interface UserRoleService {

	void insertUserRole(UserRole userRole);

	void deleteUserRole(UserRole userRole);

	List<UserRole> selectUserRoleByUserId(String userId);

}
