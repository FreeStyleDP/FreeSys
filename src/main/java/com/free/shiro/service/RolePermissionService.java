package com.free.shiro.service;

import java.util.List;

import com.free.shiro.entity.DO.RolePermission;

public interface RolePermissionService {

	void insertRolePermission(RolePermission rolePermission);

	void deleteRolePermission(RolePermission rolePermission);

	List<RolePermission> selectRolePermissionByRoleId(String roleId);

}
