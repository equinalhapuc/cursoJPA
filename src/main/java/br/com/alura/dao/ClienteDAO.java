package br.com.alura.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Cliente;

public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}

	public List<Cliente> listar() {
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

}
