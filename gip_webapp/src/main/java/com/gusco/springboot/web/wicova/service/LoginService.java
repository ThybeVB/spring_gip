package com.gusco.springboot.web.wicova.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validateUser(String uId, String password) {
		return uId.equals("Admin") && password.equals("geheim");
	}
	
}
