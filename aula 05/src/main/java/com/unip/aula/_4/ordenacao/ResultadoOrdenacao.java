package com.unip.aula._4.ordenacao;

public class ResultadoOrdenacao {

	private String nome;
	private String melhorCaso;
	private String casoMedio;
	private String piorCaso;
	
	private long comparacoes;
	private long escritas;
	private long trocas;
	private long totalOperacoes;
	private long tempoNs;
	private String vetorOrdenado;
	
	public ResultadoOrdenacao(String nome, String melhorCaso, String casoMedio, String piorCaso, long comparacoes,
			long escritas, long trocas, long totalOperacoes, long tempoNs, String vetorOrdenado) {
		this.nome = nome;
		this.melhorCaso = melhorCaso;
		this.casoMedio = casoMedio;
		this.piorCaso = piorCaso;
		this.comparacoes = comparacoes;
		this.escritas = escritas;
		this.trocas = trocas;
		this.totalOperacoes = totalOperacoes;
		this.tempoNs = tempoNs;
		this.vetorOrdenado = vetorOrdenado;
	}

	public String getNome() {
		return nome;
	}

	public String getMelhorCaso() {
		return melhorCaso;
	}

	public String getCasoMedio() {
		return casoMedio;
	}

	public String getPiorCaso() {
		return piorCaso;
	}

	public long getComparacoes() {
		return comparacoes;
	}

	public long getEscritas() {
		return escritas;
	}

	public long getTrocas() {
		return trocas;
	}

	public long getTotalOperacoes() {
		return totalOperacoes;
	}

	public long getTempoNs() {
		return tempoNs;
	}

	public String getVetorOrdenado() {
		return vetorOrdenado;
	}
	
	public double getTempoMs() {
		return tempoNs / 1_000_000.0;
	}
	
	
	
}
