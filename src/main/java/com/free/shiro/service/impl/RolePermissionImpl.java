package com.free.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.exception.BusinessException;
import com.free.shiro.dao.RolePermissionMapper;
import com.free.shiro.entity.DO.Permission;
import com.free.shiro.entity.DO.RolePermission;
import com.free.shiro.service.RolePermissionService;

@Service
public class RolePermissionImpl implements RolePermissionService {

	@Autowired
	public RolePermissionMapper rolePermissionMapper;
	
	@Override
	public void insertRolePermission(RolePermission rolePermission) {
		int insert = rolePermissionMapper.insert(rolePermission);
		if (insert != 1) {
			throw new BusinessException("插入角色权限关系失败");
		}
	}

	@Override
	public void deleteRolePermission(RolePermission rolePermission) {
		int result = rolePermissionMapper.deleteRolePermission(rolePermission);
		if(result != 1) {
			throw new BusinessException("删除角色权限关系失败");
		}
	}

	@Override
	public List<RolePermission> selectRolePermissionByRoleId(String roleId) {
		List<RolePermission> selectByRoleId = rolePermissionMapper.selectByRoleId(roleId);
		return selectByRoleId;
	}

}
