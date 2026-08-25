package com.unip.aula03.model;

import java.util.ArrayList;
import java.util.List;

public class ListaEncadeada {
	
	private Node inicio;
	
	
	public void inserirInicio(int valor) {
		
		Node novo = new Node(valor);
		novo.setProximo(inicio);
		inicio = novo;
		
	}
	
	public void inserirFim(int valor) {
		
		Node novo = new Node(valor);
		
		if(inicio == null) {
			inicio = novo;
			return;
		}
		
		Node atual = inicio;
		
		while (atual.getProximo() !=null) {
			atual = atual.getProximo();
		}
		
		atual.setProximo(novo);
		
	}
	
	
	public int removerInicio() {
		
		if (inicio == null) {
			throw new RuntimeException("A lista está Vazia!");
		}
		
		int valor = inicio.getValor();
		inicio = inicio.getProximo();
		return valor;
		
	}
	
	
	public boolean buscar(int valor) {
		
		Node atual = inicio;
		
		while (atual != null) {
			if (atual.getValor() == valor) {
				return true;
			}
			atual = atual.getProximo();
		}
		
		return false;
		
	}
	
	public int tamanho() {
		
		int contador = 0;
		Node atual = inicio;
		
		while (atual != null) {
			contador++;
			atual = atual.getProximo();
		}
		
		return contador;
		
	}
	
	public List<Integer> getElementos(){
		
		List<Integer> elementos = new ArrayList<>();
		Node atual = inicio;
		
		while (atual != null) {
			
			elementos.add(atual.getValor());
			atual = atual.getProximo();
			
		}
		
		return elementos;
		
	}
	
	public boolean isEmpty() {
		return inicio == null;
	}
	
}
