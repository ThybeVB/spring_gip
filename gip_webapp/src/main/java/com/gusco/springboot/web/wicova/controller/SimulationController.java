package com.gusco.springboot.web.wicova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gusco.springboot.web.wicova.model.Simulation;
import com.gusco.springboot.web.wicova.service.SimulationService;

@Controller
public class SimulationController {

	@Autowired
	SimulationService service;

	@RequestMapping(value = "/list-sims", method = RequestMethod.GET)
	public String showSimsPage(ModelMap model) {

		//String name = getLoggedInUsername(model);
		
		//model.put("sims", service.retrieveSims(name));
		//model.put("name", getLoggedInUsername(model));
		
		return "list-sims";
	}
	
	@RequestMapping(value = "/delete-sim", method = RequestMethod.GET)
	public String deleteSim(@RequestParam int id) {
		service.deleteSim(id);
		return "redirect:/list-sims";
	}

	@RequestMapping(value = "/simulation", method = RequestMethod.GET)
	public String showAddSimPage(ModelMap model, Simulation sim) {
		//model.addAttribute("sim", new Simulation(0, getLoggedInUsername(model), 0, 0, 0, 0));
		return "simulation";
	}

	@RequestMapping(value = "/simulation", method = RequestMethod.POST)
	public String addSim(ModelMap model, @Valid @ModelAttribute("sim") Simulation sim, BindingResult result) {
		if (result.hasErrors()) {
			return "simulation";
		}
		//String name = getLoggedInUsername(model);
		//service.addSimulation(name, sim.getKapitaal(), sim.getLoopTijd(), sim.getJaarRente());
		return "redirect:/list-sims";
	}

	@RequestMapping(value = "/update-simulation", method = RequestMethod.GET)
	public String showUpdateSimPage(ModelMap model, @RequestParam int id) {
		Simulation sim = service.retrieveSim(id);
		model.put("sim", sim);

		return "update-simulation";
	}

	@RequestMapping(value = "/update-simulation", method = RequestMethod.POST)
	public String updateSim(ModelMap model, @Valid @ModelAttribute("sim") Simulation sim, BindingResult result) {
		if (result.hasErrors()) {
			return "update-simulation";
		}

		//sim.setUser(getLoggedInUsername(model));
		service.updateSim(sim);
		
		return "redirect:/list-sims";
	}

	/*private String getLoggedInUsername(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}*/


}