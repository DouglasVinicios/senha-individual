package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class MenuController {

	@GetMapping("")
	public ModelAndView index() {
		return new ModelAndView("redirect:/menu");
	}
	
	@GetMapping("/menu")
	public ModelAndView menu() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cad() {
		return new ModelAndView("cadastro");
	}
	
	@GetMapping("/altera")
	public ModelAndView altera() {
		return new ModelAndView("altera");
	}
	
	@GetMapping("/horarios")
	public ModelAndView horarios() {
		return new ModelAndView("horarios");
	}
	
	@GetMapping("/eventos")
	public ModelAndView eventos() {
		return new ModelAndView("eventos");
	}
	
	@GetMapping("/sobre")
	public ModelAndView sobre() {
		return new ModelAndView("sobre");
	}
}
