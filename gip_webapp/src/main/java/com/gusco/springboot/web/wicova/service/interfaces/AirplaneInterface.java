package com.gusco.springboot.web.wicova.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusco.springboot.web.wicova.model.Airplane;

public interface AirplaneInterface extends JpaRepository<Airplane, Integer>{
	
}
