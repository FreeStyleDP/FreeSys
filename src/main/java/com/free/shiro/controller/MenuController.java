package com.free.shiro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.free.entity.DTO.JsonResult;
import com.free.shiro.entity.DO.Menu;
import com.free.shiro.entity.DO.Permission;
import com.free.shiro.entity.DO.User;
import com.free.shiro.service.MenuService;
import com.free.shiro.service.PermissionService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	public MenuService menuService;
	
	@Autowired
	public PermissionService permissionService;
	
	@RequestMapping("/toMenu")
	public String toMenu() {
		return "rbac_menuManage";
	}
	
	/**
	 *	读取permission 表 ，选出id 为没有 .do后缀的为菜单
	 * @return
	 * @author dengp_w
	 * @date 2018年5月11日 下午3:37:44
	 */
	@RequestMapping("/updateMenuByPermission.do")
	public JsonResult updateMenuByPermission() {
		List<Permission> permissionList = permissionService.selectMenuPermission("%.do");
		List<Menu> menuList = menuService.selectAll();
		for (Permission permission : permissionList) {
			boolean flag = false;
			for (Menu menu : menuList) {
				if (permission.getId().equals(menu.getId())) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				Menu menu1 = new Menu();
				menu1.setId(permission.getId());
				menuService.insertMenu(menu1);
			}
		}
		return JsonResult.ok();
	}
	
	@RequestMapping("/updateMenu.do")
	public JsonResult updateMenu(Menu menu ) {
		menuService.updateMenu(menu);
		return JsonResult.ok();
	}
	
	@RequestMapping("/deleteMenu.do")
	public JsonResult deleteMenu(Menu menu ) {
		menuService.deleteMenu(menu.getId());
		return JsonResult.ok();
	}
	
	@RequestMapping("/selectMenuByUserId.do")
	public JsonResult selectMenuByUserId(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Menu> menuList = menuService.selectMenuByUserId(user.getId());
		return JsonResult.ok(menuList);
	}
}
