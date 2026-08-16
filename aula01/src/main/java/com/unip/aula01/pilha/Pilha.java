package com.unip.aula01.pilha;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
	
	private List<Integer> elementos = new ArrayList<>();
	
	// Push - adiciona elemento ao topo
	public void push(int valor) {
		elementos.add(valor);
	}
	
	//Pop - remove e retorna o elemento do topo
	public int pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("A Pilha está vazia");
		}
		return elementos.remove(elementos.size() -1);
	}
	
	//PEEK - consulta o elemto do topo
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("A Pilha está vazia");
		}
		return elementos.get(elementos.size() -1);
	}
	
	// verifica se está vazia
	public boolean isEmpty() {
		return elementos.isEmpty();
	}
	
	//Retorna a quantidade de elementos
	public int size() {
		return elementos.size();
	}
	
	//retorna todos os elementos
	public List<Integer> getElementos() {
		return elementos;
	}
	
}
