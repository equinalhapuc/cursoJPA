package br.com.alura.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
	private String nome;
	private Long quantidade;
	private LocalDate data;

	public RelatorioDeVendasVo(String nome, Long quantidade, LocalDate data) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public RelatorioDeVendasVo() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nome=" + nome + ", quantidade=" + quantidade + ", data=" + data + "]";
	}

	
	
}
