package com.gusco.springboot.web.firstwebapplication619.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gusco.springboot.web.firstwebapplication619.model.Todo;
import com.gusco.springboot.web.firstwebapplication619.service.TodoRepository;
import com.gusco.springboot.web.firstwebapplication619.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoRepository repository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {

		String name = getLoggedInUsername(model);
		model.put("todos", repository.findByUser(name));
		//model.put("todos", service.retrieveTodos(name));

		return "list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		//service.deleteTodo(id);
		repository.deleteById(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model, Todo todo) {
		model.addAttribute("todo", new Todo(0, getLoggedInUsername(model), "", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUsername(model));
		//service.addTodo(a, todo.getDesc(), todo.getTargetDate(), false);
		repository.save(todo);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		//Todo todo = service.retrieveTodo(id);
		Todo todo = repository.findById(id).get();
		model.put("todo", todo);

		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUser(getLoggedInUsername(model));
		repository.save(todo);
		//service.updateTodo(todo);
		return "redirect:/list-todos";
	}

}