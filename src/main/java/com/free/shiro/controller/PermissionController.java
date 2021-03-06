package com.free.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.Permission;
import com.free.shiro.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	public PermissionService permissionService;
	
	@RequestMapping("/toPermission")
	public String toPermission() {
		return "rbac_permissionManage";
	}
	
	
	@RequestMapping(value = "/insertPermission.do", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult insertPermission(Permission permission) {
		permissionService.insertPermission(permission);
		return JsonResult.ok();
	}
	
	@RequestMapping(value = "/deletePermission.do", method=RequestMethod.POST)
	@ResponseBody
	public JsonResult deletePermission(Permission permission) {
		permissionService.deletePermission(permission.getId());
		return JsonResult.ok();
	}
	
	@RequestMapping("/updatePermission.do")
	@ResponseBody
	public JsonResult updatePermission(Permission permission) {
		permissionService.updatePermission(permission);
		return JsonResult.ok();
	}
	
	
	@RequestMapping("/selectPermission.do")
	@ResponseBody
	public JsonResult selectPermission(Pager pager) {
		pager = permissionService.selectPermission(pager);
		return JsonResult.ok(pager);
	}
}
