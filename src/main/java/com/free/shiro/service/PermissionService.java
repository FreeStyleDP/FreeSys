package com.free.shiro.service;

import java.util.List;

import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.Permission;

public interface PermissionService {

	void insertPermission(Permission permission);

	void deletePermission(String id);

	void updatePermission(Permission permission);

	public Pager selectPermission(Pager pager);

	List<Permission> selectAllPermission();

	List<Permission> selectMenuPermission(String id);

}
