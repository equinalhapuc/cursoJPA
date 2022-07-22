package br.com.alura.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.vo.RelatorioDeVendasVo;

public class PedidoDAO {
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public Pedido buscarPorId(Long id) {
		return em.find(Pedido.class, id);
	}

	public List<Pedido> listar() {
		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

	public BigDecimal valorTotalVendas() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas(){
		String jpql = "SELECT new br.com.alura.vo.RelatorioDeVendasVo("
				+ "produto.nome, "
				+ "SUM(item.quantidade),"
				+ "MAX(pedido.dataCadastro)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY SUM(item.quantidade) DESC";
		
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
		
	}
}
