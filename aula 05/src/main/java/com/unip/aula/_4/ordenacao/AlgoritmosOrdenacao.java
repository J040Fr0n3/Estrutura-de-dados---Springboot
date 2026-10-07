package com.unip.aula._4.ordenacao;

public class AlgoritmosOrdenacao {

	public static class Estatisticas {
		
		public long comparacoes = 0;
		public long escritas = 0;
		public long trocas = 0;
		
		public long getTotalOperacoes() {
			return comparacoes + escritas;
		}
		
	}
	
	// Bublle Sort
	public void bubbleSort(int[] vetor, Estatisticas e) {
		
		int n = vetor.length; //Tamanho do vetor
		
		for(int i = 0; i < n - 1; i++) {
			
			boolean trocou = false;
			
			for (int j = 0; j < n - 1; j++) {
				
				e.comparacoes++;
				
				if(vetor[j] > vetor[j + 1]) {
					int temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
					
					e.escritas += 2;
					e.trocas++;
					trocou = true;
				}
				
			}
			
			//Se não houve troca, o vetor ja está ordenado.
			if(!trocou) {
				break;
			}
			
		}
		
	}
	
	//Selection Sort
	public void selectionSort(int[] vetor, Estatisticas e) {
		
		int n = vetor.length; //Tamanho do vetor.
		
		for(int i = 0; i < n - 1; i++) {
			
			int menor = i;
			
			for (int j =  i + 1; j< n; j++) {
				
				e.comparacoes++;
				
				if(vetor[j] < vetor[menor]) {
					
					menor = j;
					
				}
				
			}
			
			if(menor != 1) {
				
				int temp = vetor[i];
				vetor[i] = vetor[menor];
				vetor[menor] = temp;
				
				e.escritas += 2;
				e.trocas++;
				
			}
			
		}
		
	}
	
	// INsertion Sort
	public void insertionSort(int[] vetor, Estatisticas e) {
		
		for(int i = 1; i < vetor.length; i++) {
			
			int chave = vetor[i];
			int j = i - 1;
			
			while (j >= 0) {
				
				e.comparacoes++;
				
				if(vetor[j] > chave) {
					
					vetor[j + 1] = vetor[j];
					e.escritas++;
					j--;
					
				} else {
					break;
				}
				
			}
			
			vetor[j + 1] = chave;
			e.escritas++;
			
		}
		
	}
	
	//Merge Sort
	public void mergeSort(int[] vetor, Estatisticas e) {
		
		int[] auxiliar = new int[vetor.length];
		mergeSort(vetor, auxiliar, 0, vetor.length - 1, e);
		
	}
	
	private void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim, Estatisticas e) {
		
		if (inicio >= fim) {
			
			return;
			
		}
		
		int meio = inicio + (fim - inicio) / 2;
		mergeSort(vetor, auxiliar, inicio, meio, e);
		mergeSort(vetor, auxiliar, meio + 1, fim, e);
		
		int i = inicio;
		int j = meio + 1;
		int k = inicio;
		
		while(i <= meio && j <= fim) {
			
			e.comparacoes++;
			
			if(vetor[i] <= vetor[j]) {
				
				auxiliar[k++] = vetor[i++];
				
			} else {
				
				auxiliar[k++] = vetor[j++];
				
			}
			
			e.escritas++;
			
		}
		
		while (i <= meio) {
			
			auxiliar[k++] = vetor[i++];
			e.escritas++;
			
		}
		
		while(j <= fim) {
			
			auxiliar[k++] = vetor[j++];
			e.escritas++;
			
		}
		
		for(int p = inicio; p <= fim; p++) {
			
			vetor[p] = auxiliar[p];
			e.escritas++;
			
		}
		
	}
	
	//Quick SOrt
	public void quickSort(int[] vetor, Estatisticas e) {
		
		quickSort(vetor, 0, vetor.length - 1, e);
		
	}
	
	private void quickSort(int[] vetor, int inicio, int fim, Estatisticas e) {
		
		if(inicio < fim) {
			
			int pivo = particionar(vetor, inicio, fim, e);
			
			quickSort(vetor, inicio, pivo - 1, e);
			quickSort(vetor, pivo + 1, fim, e);
			
		}
		
	}
	
	private int particionar(int[] vetor, int inicio, int fim, Estatisticas e) {
		
		
		int pivo = vetor[fim];
		int i = inicio - 1;
		
		for(int j = inicio; j < fim; j++) {
			
			e.comparacoes++;
			
			if (vetor[j] <= pivo) {
				
				i++;
				if(i != j) {
					
					trocar(vetor, i, j, e);
					
				}
				
			}
			
		}
		
		if(i + 1 != fim) {
			trocar(vetor, i + 1, fim, e);
		}
		
		return i + 1;
		
	}
	
	private void trocar(int[] vetor, int i, int j, Estatisticas e) {
		
		int temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
		
		e.escritas += 2;
		e.trocas++;
		
	}
	
}
