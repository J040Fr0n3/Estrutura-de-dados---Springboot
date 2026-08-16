package com.unip.aula01.fila;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fila")
public class FilaController {
	private Fila fila = new Fila();
	
	//PUSH
	@GetMapping("/push/{valor}")
	public String push(@PathVariable int valor) {
		fila.push(valor);
		return "Valor " + valor + " inserido na fila.";
	}
	
	//POP
	@GetMapping("/pop")
	public String pop() {
		int valor = fila.pop();
		
		return "Valor removido: " + valor;
	}
	
	//peek
	@GetMapping("/peek")
	public String peek() {
		int valor = fila.peek();
		
		return "Valor do começo :" + valor;
	}
	
	//size
	@GetMapping("/size")
	public String size() {
		return "Quantidade de elementos: " + fila.size();
	}
	
	//Exibir fila
	@GetMapping
	public Object listar() {
		return fila.getElementos();
	}
	
}
