package com.unip.aula._4.ordenacao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdenacaoController {
	
	private final OrdenacaoService service;
	
	public OrdenacaoController(OrdenacaoService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/ordenacao";
	}
	
	@GetMapping("/ordenacao")
	public String pagina() {
		
		return "ordenacao";
		
	}
	
	@PostMapping("/ordenacao")
	public String executar(@RequestParam(defaultValue = "1000000") int tamanho, Model model) {
		
		if(tamanho < 1 || tamanho > 1000000) {
			
			model.addAttribute("erro", "Infotme um tamanho entre 1 e 5000");
			return "ordenacao";
			
		}
		
		model.addAttribute("tamanho", tamanho);
		model.addAttribute("resultados", service.comparar(tamanho));
		
		return "ordenacao";
		
	}
}
