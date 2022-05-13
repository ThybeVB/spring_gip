package com.gusco.springboot.web.wicova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gusco.springboot.web.wicova.model.Aflossing;
import com.gusco.springboot.web.wicova.model.Simulation;
import com.gusco.springboot.web.wicova.service.AflossingService;
import com.gusco.springboot.web.wicova.service.SimulationService;

@Controller
public class AnnuityTableController {
	
	@Autowired
	AflossingService service;
	
	@Autowired
	SimulationService simService;

	@RequestMapping(value = "/show-simulation", method = RequestMethod.GET)
	public String showTable(ModelMap map, @RequestParam int id) {
		service.flush();
		
		Simulation sim = simService.retrieveSim(id);
		
		double pmt = this.calculatePayment(sim.getKapitaal(), sim.getJaarRente(), sim.getLoopTijd());
		sim.setPmt(service.round(pmt, 2));

		map.put("sim", sim);
		map.put("uName", sim.getUser());
		
		List<Aflossing> aflossingen = service.getAflossingen(sim);
		map.put("aflossingen", aflossingen);
		
		return "show-simulation";
	}
	
	private double calculatePayment(double kapitaal, double rente, int loopTijd) {
		double maandRente = service.getMaandRente(rente);
		
		double topPart = (double) (kapitaal * maandRente);
		double bottomPart = (double) (1 - Math.pow(1 + maandRente, -loopTijd));
		
		return topPart / bottomPart;
	}
}
