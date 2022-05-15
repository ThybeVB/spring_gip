package com.gusco.springboot.web.wicova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gusco.springboot.web.wicova.service.PlaneService;

@Controller
@SessionAttributes("name")
public class PlaneController {
	
	@Autowired
	PlaneService service;
	
	@RequestMapping(value = "/list-planes", method = RequestMethod.GET)
	public String showPlanesPage(ModelMap model) {
		model.put("planes", service.retrievePlanes());
		return "list-planes";
	}
	
	@RequestMapping(value = "/add-plane")
	public String showAddPlanePage(ModelMap model) {
		return "add-plane"; //TODO
	}
	
	@RequestMapping(value = "/update-plane")
	public String showUpdatePlanePage(ModelMap model) {
		return "update-plane"; //TODO
	}
	
	@RequestMapping(value = "/delete-plane")
	public String deletePlane(@RequestParam int id) {
		service.deletePlane(id);
		return "redirect:/list-planes";
	}
	
}
