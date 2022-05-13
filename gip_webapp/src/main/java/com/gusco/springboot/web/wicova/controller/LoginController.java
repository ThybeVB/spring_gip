package com.gusco.springboot.web.wicova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gusco.springboot.web.wicova.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	public LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		if (!isValidUser) {
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "welcome";
	}
}