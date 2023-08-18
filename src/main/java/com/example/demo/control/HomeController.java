package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.ContatoDAO;

@Controller
public class HomeController {
	@Autowired
	ContatoDAO dao;
	
	@GetMapping("/")
	public String Home(ModelMap model) {
		int valores[] = { 1, 3, 5, 7, 9 };
		model.addAttribute("valores", valores);
		model.addAttribute("nome", "Apenas um teste");
		model.addAttribute("contatos", dao.findAll());
		return "index";
	}
}
