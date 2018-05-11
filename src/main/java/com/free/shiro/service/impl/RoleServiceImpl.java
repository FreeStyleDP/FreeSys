package com.free.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.entity.DTO.Pager;
import com.free.exception.BusinessException;
import com.free.shiro.dao.RoleMapper;
import com.free.shiro.entity.DO.Role;
import com.free.shiro.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	public RoleMapper roleMapper;

	@Override
	public void insertRole(Role role) {
		int insert = roleMapper.insert(role);
		if(insert != 1) {
			throw new BusinessException("插入角色失败");
		}
	}

	@Override
	public void deleteRole(String id) {
		int deleteByPrimaryKey = roleMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey != 1) {
			throw new BusinessException("删除角色失败");
		}
	}

	@Override
	public void updateRole(Role role) {
		int updateByPrimaryKey = roleMapper.updateByPrimaryKey(role);
		if (updateByPrimaryKey != 1) {
			throw new BusinessException("更新角色失败");
		}
		
	}

	@Override
	public Pager selectRole(Pager pager) {
		PageHelper.startPage(pager.getCurrentPage(), pager.getPageSize());
		List<Role> selectAll = roleMapper.selectAll();
		
		PageInfo<Role> pageInfo = new PageInfo<>(selectAll);
		pager.setContent(selectAll);
		pager.setRecordTotal((int) pageInfo.getTotal());
		
		return pager;
	}

}
