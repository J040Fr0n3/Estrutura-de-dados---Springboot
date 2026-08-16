package com.unip.aula01.fila;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	private List<Integer> elementos = new ArrayList<>();
	
	//push -adiciona elementos a fila.
	public void push(int valor) {
		elementos.add(valor);
	}
	
	//Pop - remove elementos do começoda fila
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("A fila está vazia");
		}
		return elementos.remove(0);
	}
	
	//peek - consulta o primeiro elemento sem remover.
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		return elementos.get(0);
	}
	
	//Verificar se está vazia
	public boolean isEmpty() {
		return elementos.isEmpty();
	}
	
	//retorna a quantidade de elementos
	public int size() {
		return elementos.size();
	}
	
	//retorna todos os elementos
	public List<Integer> getElementos(){
		return elementos;
	}
	
}
