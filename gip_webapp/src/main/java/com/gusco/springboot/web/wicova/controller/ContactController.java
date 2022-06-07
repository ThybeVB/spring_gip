package com.gusco.springboot.web.wicova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.gusco.springboot.web.wicova.model.ContactForm;
import com.gusco.springboot.web.wicova.service.interfaces.FormInterface;

@Controller
@SessionAttributes("name")
public class ContactController {
	
	@Autowired
	FormInterface formInterface;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContactPage(ModelMap model) {
		model.addAttribute("contactform", new ContactForm());
		return "contact";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String submitContactForm(ModelMap model, @Valid @ModelAttribute("contactform") ContactForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "contact";
		}
		
		formInterface.save(form);
		
		return "contact";
	}
}