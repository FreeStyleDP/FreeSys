package com.free.shiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.shiro.entity.DO.UserRole;
import com.free.shiro.service.UserRoleService;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	
	@Autowired
	public UserRoleService userRoleService;
	
	@RequestMapping("/insertUserRole.do")
	@ResponseBody
	public JsonResult insertUserRole(UserRole userRole) {
		userRoleService.insertUserRole(userRole);
		return JsonResult.ok();
	}
	
	@RequestMapping("/deleteUserRole.do")
	@ResponseBody
	public JsonResult deleteUserRole(UserRole userRole) {
		userRoleService.deleteUserRole(userRole);
		return JsonResult.ok();
	}
	
	@RequestMapping("/selectUserRole.do")
	@ResponseBody
	public JsonResult selectUserRoleByUserId(UserRole userRole ) {
		List<UserRole> userRoles = userRoleService.selectUserRoleByUserId(userRole.getUserId());
		return JsonResult.ok(userRoles);
	}
}
