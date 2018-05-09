package com.free.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.entity.DTO.Pager;
import com.free.shiro.RoleService.RoleService;
import com.free.shiro.entity.DO.Role;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	public RoleService roleService;
	
	@RequestMapping("/insertRole")
	@ResponseBody
	public JsonResult insertRole(Role role) {
		roleService.insertRole(role);
		return JsonResult.ok();
	}
	
	@RequestMapping("/deleteRole")
	@ResponseBody
	public JsonResult deleteRole(Role role) {
		roleService.deleteRole(role.getId());
		return JsonResult.ok();
		
	}
	
	@RequestMapping("/updateRole")
	@ResponseBody
	public JsonResult updateRole(Role role) {
		roleService.updateRole(role);
		return JsonResult.ok();
		
	}
	
	@RequestMapping("/selectRole")
	@ResponseBody
	public JsonResult selectRole(Pager pager) {
		Pager roleList = roleService.selectRole(pager);
		return JsonResult.ok(roleList);
		
	}

}