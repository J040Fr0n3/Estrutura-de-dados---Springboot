package com.unip.aula01.pilha;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pilha")
public class PilhaController {
	private Pilha pilha = new Pilha();
	
	//Push
	@GetMapping("/push/{valor}")
	public String push(@PathVariable int valor) {
		pilha.push(valor);
		
		return "Valor " + valor + " inserido na pilha";
	}
	
	//Pop
	@GetMapping("/pop")
	public String pop() {
		int valor = pilha.pop();
		
		return "Valor removido: " + valor;
	}
	
	//Peek
	@GetMapping("/peek")
	public String peek() {
		int valor = pilha.peek();
		
		return "Valor no topo: " + valor;
	}
	
	//size
	@GetMapping("/size")
	public String size() {
		return "Quantidade de elementos: " + pilha.size();
	}
	
	//Exibit pilha
	@GetMapping
	public Object listar() {
		return pilha.getElementos();
	}
	
}
