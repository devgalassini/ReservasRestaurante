package br.com.puglia.galassini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HomeController {
	
	@GetMapping("/") 
	public ModelAndView iniciar() {
		return new ModelAndView("home"); 
	}
	
	@GetMapping("/texto")
	public ModelAndView mostrarMenu() {
		return new ModelAndView("menu");
	}
}