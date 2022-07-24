package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto {
	private String marca;
	private String modelo;

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Informatica(String nome, String descricao, BigDecimal preco, Categoria categoria, String marca,
			String modelo) {
		super(nome, descricao, preco, categoria);
		this.marca = marca;
		this.modelo = modelo;
	}

}
