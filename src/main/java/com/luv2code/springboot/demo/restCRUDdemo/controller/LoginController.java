package com.luv2code.springboot.demo.restCRUDdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class LoginController {
	
	@GetMapping("/showLogin")
	public String showLogin() {
		return "login/fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "login/access-denied";
	}
	
}
