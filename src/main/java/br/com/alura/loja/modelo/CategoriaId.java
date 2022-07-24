package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId {
	private String nome;
	private String tipo;

	public CategoriaId() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaId(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

}
