package com.free.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.Role;
import com.free.shiro.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	public RoleService roleService;
	
	@RequestMapping("/toRole")
	public String toRole() {
//		return "informManage";
		return "rbac_roleManage";
	}
	
	@RequestMapping("/insertRole.do")
	@ResponseBody
	public JsonResult insertRole(Role role) {
		roleService.insertRole(role);
		return JsonResult.ok();
	}
	
	@RequestMapping("/deleteRole.do")
	@ResponseBody
	public JsonResult deleteRole(Role role) {
		roleService.deleteRole(role.getId());
		return JsonResult.ok();
		
	}
	
	@RequestMapping("/updateRole.do")
	@ResponseBody
	public JsonResult updateRole(Role role) {
		roleService.updateRole(role);
		return JsonResult.ok();
		
	}
	
	@RequestMapping("/selectRole.do")
	@ResponseBody
	public JsonResult selectRole(Pager pager) {
		Pager roleList = roleService.selectRole(pager);
		return JsonResult.ok(roleList);
		
	}

}
