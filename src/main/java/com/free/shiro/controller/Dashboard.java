package com.free.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
@Controller
public class Dashboard {

	@RequestMapping("/toDashboard")
	public String toDashboard() {
		return "dashboard";
	}
}
