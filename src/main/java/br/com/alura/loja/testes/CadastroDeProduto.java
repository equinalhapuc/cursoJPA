package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		Categoria celulares = new Categoria("Celulares");
		em.getTransaction().begin();
		categoriaDAO.salvar(celulares);
		
		Produto celular = new Produto("Xiaomi RedMi", "Camera 40 MP", new BigDecimal("1500.0"), celulares);

		ProdutoDAO produtoDAO = new ProdutoDAO(em);

		// Quando transaction-type="RESOURCE_LOCAL" na persistence-unit é necessário
		// gerenciar a transaction manualmente
		// Quando é utilizado algum servidor de aplicações, as transações são
		// gerenciadas automaticamente.
		
		produtoDAO.salvar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
