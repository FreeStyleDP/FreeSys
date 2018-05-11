package com.free.shiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.shiro.entity.DO.RolePermission;
import com.free.shiro.service.RolePermissionService;

@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController {
	
	@Autowired 
	public RolePermissionService rolePermissionService;
	
	@RequestMapping("/inserRolePermission.do")
	@ResponseBody
	public JsonResult insertRolePermission(RolePermission rolePermission) {
		rolePermissionService.insertRolePermission(rolePermission);
		return JsonResult.ok();
	}
	
	@RequestMapping("/deleteRolePermission.do")
	@ResponseBody
	public JsonResult deleteRolePermission(RolePermission rolePermission) {
		rolePermissionService.deleteRolePermission(rolePermission);
		return JsonResult.ok();
	}
	
	@RequestMapping("/selectRolePermissionByRoleId.do")
	@ResponseBody
	public JsonResult selectRolePermissionByRoleId(RolePermission rolePermission) {
		List<RolePermission> rolePermissions = rolePermissionService.selectRolePermissionByRoleId(rolePermission.getRoleId());
		return JsonResult.ok(rolePermissions);
	}
}
