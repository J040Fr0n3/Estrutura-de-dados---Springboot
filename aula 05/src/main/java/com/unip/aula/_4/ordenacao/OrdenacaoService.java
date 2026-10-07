package com.unip.aula._4.ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OrdenacaoService {

private final AlgoritmosOrdenacao algoritmos = new AlgoritmosOrdenacao();
	
	public List<ResultadoOrdenacao> comparar (int tamanho) {
		
		Random random = new Random();
		
		int[] original = new int[tamanho];
		
		for(int i = 0; i < tamanho; i++) {
			original[i] = random.nextInt(100_00);
		}
		
		List<ResultadoOrdenacao> resultados = new ArrayList<>();
		executar(resultados, original, "Bubble Sort", "O(n)", "O(n2)", "O(n2)", "bubble");
		executar(resultados, original, "Selection Sort", "O(n2)", "O(n2)", "O(n2)", "selection");
		executar(resultados, original, "Insertion Sort", "O(n)", "O(n2)", "O(n2)", "insertion");
		executar(resultados, original, "Merge Sort", "O(n log n)", "O(n log n)", "O(n log n)", "merge");
		executar(resultados, original, "Quick Sort", "O(n log n)", "O(n log n)", "O(n2)", "quick");
		
		return resultados;
	}
	
	private void executar(
			List<ResultadoOrdenacao> resultados,
			int[] original,
			String nome,
			String melhor,
			String medio,
			String pior,
			String tipo) {
		
		int[] vetor = original.clone();
		
		AlgoritmosOrdenacao.Estatisticas estatisticas = new AlgoritmosOrdenacao.Estatisticas();
		
		long inicio = System.nanoTime();
		
		switch(tipo) {
		case "bubble" -> algoritmos.bubbleSort(vetor, estatisticas);
		case "selection" -> algoritmos.selectionSort(vetor, estatisticas);
		case "insertion" -> algoritmos.insertionSort(vetor, estatisticas);
		case "merge" -> algoritmos.mergeSort(vetor, estatisticas);
		case "quick" -> algoritmos.quickSort(vetor, estatisticas);
		}
		
		long fim = System.nanoTime();
		long tempo = fim - inicio;
		
		//Mostra apenas os primeiros 30 valores para não
		//Sobrecarregar a interface
		int limite = Math.min(vetor.length, 30);
		String amostra = Arrays.toString(Arrays.copyOf(vetor, limite));
		
		if(vetor.length > limite) {
			amostra += "...";
		}
		
		resultados.add(new ResultadoOrdenacao(nome, melhor, medio, pior, limite, inicio, fim, limite, tempo, amostra));
		
	}
	
}
