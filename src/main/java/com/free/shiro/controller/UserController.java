package com.free.shiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;
import com.free.entity.DTO.Pager;
import com.free.shiro.entity.DO.User;
import com.free.shiro.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService ;
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public JsonResult insertUser(User user) {
		userService.insertUser(user);
		return new JsonResult("");
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public JsonResult deleteUser(User user) {
		userService.deleteUser(user.getId());
		return new JsonResult("");
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public JsonResult updateUser(User user) {
		userService.updateUser(user);
		
		return new JsonResult("");
	}
	
	@RequestMapping("/selectUser")
	@ResponseBody
	public JsonResult selectUser( Pager pager) {
		Pager users = userService.selectUser(pager);
		return new JsonResult(users);
	}
	
	@RequestMapping("/selectAllUser")
	@ResponseBody
	public JsonResult selectAllUser() {
		List<User> selectAllUsers =userService.selectAllUsers();
		return new JsonResult(selectAllUsers);
	}
	
}
