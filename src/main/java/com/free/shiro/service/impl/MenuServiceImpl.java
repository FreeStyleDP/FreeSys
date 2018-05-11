package com.free.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.exception.BusinessException;
import com.free.shiro.dao.MenuMapper;
import com.free.shiro.entity.DO.Menu;
import com.free.shiro.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	public MenuMapper menuMapper;
	
	@Override
	public void deleteMenu(String id) {
		int deleteByPrimaryKey = menuMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey != 1) {
			throw new BusinessException("菜单删除失败");
		}
	}

	@Override
	public void updateMenu(Menu menu) {
		int updateByPrimaryKey = menuMapper.updateByPrimaryKey(menu);
		if (updateByPrimaryKey != 1) {
			throw new BusinessException("更新菜单失败");
		}
	}

	@Override
	public List<Menu> selectMenuByUserId(String id) {
		List<Menu> menuList = menuMapper.selectMenuByUserId(id);
		return menuList;
	}
	
	@Override
	public void insertMenu(Menu menu) {
		int insert = menuMapper.insert(menu);
		if (insert != 1) {
			throw new BusinessException("插入菜单失败");
		}
	}

	@Override
	public List<Menu> selectAll() {
		return menuMapper.selectAll();
	}

}
