package com.free.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.entity.DTO.Pager;
import com.free.exception.BusinessException;
import com.free.shiro.dao.PermissionMapper;
import com.free.shiro.entity.DO.Permission;
import com.free.shiro.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	public PermissionMapper permissionMapper;
	
	@Override
	public void insertPermission(Permission permission) {
		int insert = permissionMapper.insert(permission);
		if(insert != 1) {
			throw new BusinessException("插入权限失败");
		}
	}

	@Override
	public void deletePermission(String id) {
		int deleteByPrimaryKey = permissionMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey != 1) {
			throw new BusinessException("删除权限失败");
		}
	}

	@Override
	public void updatePermission(Permission permission) {
		int updateByPrimaryKey = permissionMapper.updateByPrimaryKey(permission);
		if (updateByPrimaryKey != 1) {
			throw new BusinessException("更新权限失败");
		}
	}

	@Override
	public Pager selectPermission(Pager pager) {
		PageHelper.startPage(pager.getCurrentPage(),pager.getPageSize());
		List<Permission> selectAll = permissionMapper.selectAll();
		
		PageInfo<Permission> pageInfo = new PageInfo<>(selectAll);
		pager.setRecordTotal((int) pageInfo.getTotal());
		return null;
	}

}
