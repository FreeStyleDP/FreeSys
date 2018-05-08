package com.free.shiro.RoleService;

import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.Role;

public interface RoleService {

	void insertRole(Role role);

	void deleteRole(String id);

	void updateRole(Role role);

	Pager selectRole(Pager pager);

}
