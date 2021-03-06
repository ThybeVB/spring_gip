package com.gusco.springboot.web.wicova.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gusco.springboot.web.wicova.model.Airplane;
import com.gusco.springboot.web.wicova.service.interfaces.AirplaneInterface;

import util.FileUploadUtil;

@Controller
@SessionAttributes("name")
public class PlaneController {
	
	@Autowired
	AirplaneInterface airplaneInterface;
	
	@RequestMapping(value = "/list-planes", method = RequestMethod.GET)
	public String showPlanesPage(ModelMap model) {
		model.put("planes", airplaneInterface.findAll());
		return "list-planes";
	}
	
	@RequestMapping(value="/plane-annuity-dialog", method = RequestMethod.GET)
	public String showAnnuityDialog(ModelMap model, @RequestParam int id) {
		Airplane plane = airplaneInterface.getById(id);
		model.put("plane", plane);
		return "plane-annuity-dialog";
	}
	
	@RequestMapping(value = "/add-plane", method = RequestMethod.GET)
	public String showAddPlanePage(ModelMap model) {
		model.addAttribute("plane", new Airplane());
		return "add-plane";
	}
	
	@RequestMapping(value = "/add-plane", method = RequestMethod.POST)
	public String addPlane(ModelMap model, @Valid @ModelAttribute("plane") Airplane plane, BindingResult result) throws IOException {
		if (result.hasErrors()) {
			return "add-plane";
		}
		
		String fileName = StringUtils.cleanPath(plane.getPicture().getOriginalFilename());
		plane.setPictureUrl(fileName);		
		Airplane savedPlane = airplaneInterface.save(plane);
		
		String uploadDir = "src/main/webapp/plane-photos/" + savedPlane.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, plane.getPicture());
		
		return "redirect:/list-planes";
	}
	
	@RequestMapping(value = "/update-plane", method = RequestMethod.GET)
	public String showUpdatePlanePage(ModelMap model, @RequestParam int id) {
		Airplane plane = airplaneInterface.getById(id);
		model.put("plane", plane);
		return "update-plane";
	}
	
	@RequestMapping(value = "/update-plane", method = RequestMethod.POST)
	public String updateSim(ModelMap model, @Valid @ModelAttribute("plane") Airplane plane, BindingResult result) throws IOException {
		if (result.hasErrors()) {
			return "update-plane";
		}
		
		if (!plane.getPicture().isEmpty() && plane.getPicture() != null) {
			String fileName = StringUtils.cleanPath(plane.getPicture().getOriginalFilename());
			plane.setPictureUrl(fileName);		
			Airplane savedPlane = airplaneInterface.save(plane);
			
			String uploadDir = "src/main/webapp/plane-photos/" + savedPlane.getId();
	        FileUploadUtil.saveFile(uploadDir, fileName, plane.getPicture());
		}
		
		airplaneInterface.save(plane);
		
		return "redirect:/list-planes";
	}
	@RequestMapping(value = "/delete-plane")
	public String deletePlane(@RequestParam int id) {
		Airplane plane = airplaneInterface.getById(id);
		airplaneInterface.delete(plane);
		return "redirect:/list-planes";
	}
	
}
