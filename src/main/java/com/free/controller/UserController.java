package com.free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DO.User;
import com.free.entity.DTO.JsonResult;
import com.free.service.UserService;

import ch.qos.logback.core.net.LoginAuthenticator;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService ;
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public JsonResult insertUser(User user) {
		userService.insertUser(user);
		return new JsonResult("");
	}
	
	@RequestMapping("/selectAllUsers")
	@ResponseBody
	public JsonResult selectUser(User user) {
		List<User> selectAllUsers =userService.selectAllUsers();
		return new JsonResult(selectAllUsers);
	}
	
}
