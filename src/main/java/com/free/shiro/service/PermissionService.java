package com.free.shiro.service;

import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.Permission;

public interface PermissionService {

	void insertPermission(Permission permission);

	void deletePermission(String id);

	void updatePermission(Permission permission);

	Pager selectPermission(Pager pager);

}
