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
import com.gusco.springboot.web.wicova.model.User;
import com.gusco.springboot.web.wicova.service.interfaces.UserInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	public UserInterface userInterface;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @Valid @ModelAttribute("user") User user, BindingResult result) throws NoSuchAlgorithmException {
		if (result.hasErrors()) {
			return "login";
		}
		
		String rawPass = user.getPassword();
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(rawPass.getBytes());
	    byte[] digest = md.digest();      
	    StringBuffer hexString = new StringBuffer();
	    
	    for (int i = 0; i < digest.length; i++) {
	         hexString.append(Integer.toHexString(0xFF & digest[i]));
	    }
	    
	    user.setPassword(hexString.toString());
	    
	    boolean isValidUser = this.validateUser(user);
	    if (!isValidUser) {
	    	return "login";
	    }
		
		model.put("name", user.getName());
		model.put("password", hexString.toString());
		
		return "redirect:/welcome";
	}
	
	private boolean validateUser(User user) {
		List<User> users = userInterface.findAll();
		for (int i = 0; i < users.size(); i++) {
			User refUser = users.get(i);
			if (refUser.getName().equals(user.getName()) && refUser.getPassword().equals(user.getPassword())) {
				return true;
			}
			i++;
		}
		return false;
	}
}
