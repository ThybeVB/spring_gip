package com.gusco.springboot.web.wicova.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusco.springboot.web.wicova.model.ContactForm;

public interface FormInterface extends JpaRepository<ContactForm, Integer> {

}
