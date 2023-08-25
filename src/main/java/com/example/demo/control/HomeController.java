package com.example.demo.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Contato;
import com.example.demo.model.ContatoDAO;

@Controller
public class HomeController {

	@Autowired
	ContatoDAO dao;

	@GetMapping("/")
	public String home(ModelMap mapa) {
		int valores[] = { 1, 3, 5, 7, 9 };
		mapa.addAttribute("valores", valores);
		mapa.addAttribute("nome", "Apenas um Teste");
		mapa.addAttribute("contatos", dao.findAll());
		return "index";
	}

	@GetMapping("/contatos")
	public String obterContatos(ModelMap mapa) {
		mapa.addAttribute("contato", dao.findAll());
		return "contatosLista";
	}

	@GetMapping("/contatos/edit/{id}")
	public String editarContato(Model model, @PathVariable(name = "id", required = false) Integer id) {
		if (id != null) {
			model.addAttribute("contato", dao.findById(id).get());
		} else {
			model.addAttribute("contato", new Contato());
		}
		return "contatosForm";
	}

	@PostMapping("/contatos/save")
	public String saveContato(@ModelAttribute Contato contato) {
		if (contato != null) {
			dao.save(contato);
		}

		return "redirect:/contatos";
	}

	@GetMapping("/contatos/delete")
	public String removerContato(ModelMap mapa, @RequestParam(name = "id", required = true) Integer id) {
		if (id != null) {
			dao.deleteById(id);
			return "contatosLista";
		} else {
			return "contatosLista";
		}
	}
}
