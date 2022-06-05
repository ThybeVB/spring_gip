package com.gusco.springboot.web.wicova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ContactController {

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContactPage(ModelMap model) {
		return "contact";
	}
}