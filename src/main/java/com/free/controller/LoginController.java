package com.free.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "login";
	}
}
