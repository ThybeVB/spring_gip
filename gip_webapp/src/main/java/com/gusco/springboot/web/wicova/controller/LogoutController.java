package com.gusco.springboot.web.wicova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap map, WebRequest request, SessionStatus status) { 
		map.clear();
		status.setComplete();
		request.removeAttribute("name", WebRequest.SCOPE_SESSION);
		return "redirect:/welcome";
	}
	
}
