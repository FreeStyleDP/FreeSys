package com.free.shiro.service;

import java.util.List;

import com.free.shiro.entity.DO.Menu;

public interface MenuService {

	void deleteMenu(String id);

	void updateMenu(Menu menu);

	List<Menu> selectMenuByUserId(String id);

	void insertMenu(Menu menu);

	List<Menu> selectAll();

}
