package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@EmbeddedId
	private CategoriaId id;
	
	public Categoria(String nome) {
		this.id = new CategoriaId(nome, "xpto");
	}
	
	
	// Para o select, o JPA necessita do construtor padrão
	public Categoria() {
		
	}
	
	public Long getId() {
		return this.getId();
	}

	public String getNome() {
		return this.id.getNome();
	}
}
