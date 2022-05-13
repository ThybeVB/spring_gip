package com.gusco.springboot.web.firstwebapplication619.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusco.springboot.web.firstwebapplication619.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	List<Todo> findByUser(String todo);
}
