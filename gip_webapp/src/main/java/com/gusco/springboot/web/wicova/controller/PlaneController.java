package com.gusco.springboot.web.wicova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gusco.springboot.web.wicova.model.Airplane;
import com.gusco.springboot.web.wicova.model.Simulation;
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
	
	@RequestMapping(value = "/add-plane", method = RequestMethod.GET)
	public String showAddPlanePage(ModelMap model) {
		model.addAttribute("plane", new Airplane(0, null, null, null, 0));
		return "add-plane";
	}
	
	@RequestMapping(value = "/add-plane", method = RequestMethod.POST)
	public String addPlane(ModelMap model, @Valid @ModelAttribute("plane") Airplane plane, BindingResult result) {
		if (result.hasErrors()) {
			return "update-plane";
		}
		
		service.addPlane(plane.getName(), plane.getDescription(), plane.getBrand(), plane.getPrice());
		
		return "redirect:/list-planes";
	}
	
	@RequestMapping(value = "/update-plane", method = RequestMethod.GET)
	public String showUpdatePlanePage(ModelMap model, @RequestParam int id) {
		Airplane plane = service.retrievePlane(id);
		model.put("plane", plane);
		return "update-plane";
	}
	
	@RequestMapping(value = "/update-plane", method = RequestMethod.POST)
	public String updateSim(ModelMap model, @Valid @ModelAttribute("plane") Airplane plane, BindingResult result) {
		if (result.hasErrors()) {
			return "update-simulation";
		}

		service.updatePlane(plane);
		
		return "redirect:/list-planes";
	}
	@RequestMapping(value = "/delete-plane")
	public String deletePlane(@RequestParam int id) {
		service.deletePlane(id);
		return "redirect:/list-planes";
	}
	
}
