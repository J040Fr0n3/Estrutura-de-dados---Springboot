package com.unip.aula03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unip.aula03.model.ListaEncadeada;

@Controller
@RequestMapping("/lista")
public class ListaController {
	
	private ListaEncadeada lista = new ListaEncadeada();
	
	@GetMapping
	public String visualizar(Model model) {
		
		model.addAttribute("elementos", lista.getElementos());
		
		model.addAttribute("tamanho", lista.tamanho());
		
		return "lista";
	}
	
	
	@PostMapping("/inicio")
	public String inserirInicio(@RequestParam int valor) {
		
		lista.inserirInicio(valor);
		return "redirect:/lista";
		
	}
	
	@PostMapping("/fim")
	public String insierirFim(@RequestParam int valor) {
		
		lista.inserirFim(valor);
		return "redirect:/lista";
		
	}
	
	@PostMapping("/remover")
	public String remover() {
		
		if(!lista.isEmpty()) {
			lista.removerInicio();
		}
		
		return "redirect:/lista";
		
	}
	
	@PostMapping("/buscar")
	public String buscar(@RequestParam int valor, Model model) {
		
		boolean encontrado = lista.buscar(valor);
		model.addAttribute("elementos", lista.getElementos());
		model.addAttribute("tamanho", lista.tamanho());
		model.addAttribute("busca", valor);
		model.addAttribute("encontrado", encontrado);
		
		return "lista";
	}
	
}
