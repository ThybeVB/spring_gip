package com.gusco.springboot.web.wicova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gusco.springboot.web.wicova.model.Aflossing;
import com.gusco.springboot.web.wicova.model.Airplane;
import com.gusco.springboot.web.wicova.service.AflossingService;
import com.gusco.springboot.web.wicova.service.PlaneService;

@Controller
@SessionAttributes("name")
public class AnnuityTableController {
	
	@Autowired
	AflossingService service;
	
	@Autowired
	PlaneService airplaneService;
	
	@RequestMapping(value = "/plane-annuity-dialog", method = RequestMethod.POST)
	public String showTable(ModelMap map, @Valid @ModelAttribute("plane") Airplane plane, BindingResult result) {
		if (result.hasErrors()) {
			return "plane-annuity-dialog";
		}
		
		service.flush();
		
		Airplane airplane = airplaneService.retrievePlane(plane.getId());
		airplane.setJaarRente(plane.getJaarRente());
		airplane.setLoopTijd(plane.getLoopTijd());
		
		double pmt = this.calculatePayment(airplane.getPrice(), airplane.getJaarRente(), airplane.getLoopTijd());
		airplane.setPmt(service.round(pmt, 2));
		
		map.put("plane", airplane);
		
		List<Aflossing> aflossingen = service.getAflossingen(airplane);
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
