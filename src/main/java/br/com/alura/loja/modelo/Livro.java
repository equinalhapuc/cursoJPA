package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Livro extends Produto {

	private String autor;
	private Integer numeroDePaginas;

	public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor,
			Integer numeroDePaginas) {
		super(nome, descricao, preco, categoria);
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

}
