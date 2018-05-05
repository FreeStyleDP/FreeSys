package com.free.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.entity.DTO.JsonResult;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public JsonResult businessHandler(HttpServletRequest req, 
			Exception e) {
//		e.printStackTrace();
		System.out.println(e.getMessage());
		return new JsonResult(500, e.getMessage(), "");
		
	}
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonResult otherHandler(HttpServletRequest req, 
			Exception e) {
//		e.printStackTrace();
		System.out.println(e.getMessage());
		return new JsonResult(500, "系统异常", "");
		
	}
}
