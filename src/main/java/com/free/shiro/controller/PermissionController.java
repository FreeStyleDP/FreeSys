package com.free.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.Permission;
import com.free.shiro.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	public PermissionService permissionService;
	
	@RequestMapping("/insertPermission")
	@ResponseBody
	public JsonResult insertPermission(Permission permission) {
		permissionService.insertPermission(permission);
		return JsonResult.ok();
	}
	
	@RequestMapping("/deletePermission")
	@ResponseBody
	public JsonResult deletePermission(Permission permission) {
		permissionService.deletePermission(permission.getId());
		return JsonResult.ok();
	}
	
	@RequestMapping("/updatePermission")
	@ResponseBody
	public JsonResult updatePermission(Permission permission) {
		permissionService.updatePermission(permission);
		return JsonResult.ok();
	}
	
	@RequestMapping("/selectPermission")
	@ResponseBody
	public JsonResult selectPermission(Pager pager) {
		pager = permissionService.selectPermission(pager);
		return JsonResult.ok(pager);
	}
}
