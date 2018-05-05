package com.free.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DO.User;
import com.free.entity.DTO.JsonResult;
import com.free.exception.BusinessException;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/loginUser" , method = RequestMethod.POST)
	@ResponseBody
	public JsonResult loginUser(User user,HttpSession session) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(),user.getPassword());
		
		Subject subject = SecurityUtils.getSubject();
		try { 
			subject.login(usernamePasswordToken);
		} catch (UnknownAccountException e) {
			throw new BusinessException("账号不存在");
		} catch (IncorrectCredentialsException e) {
			throw new BusinessException("密码不正确");
		} catch (LockedAccountException e) {
			throw new BusinessException("账号被锁，不能登录");
		} catch (AuthenticationException e) {
			throw new BusinessException("认证失败");
		} 
		
		User user1 = (User) subject.getPrincipal();
		
		session.setAttribute("user", user1);
		
		return new JsonResult("");
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
//		session.removeAttribute("user");
		return "redirect:/login";
	}
}
