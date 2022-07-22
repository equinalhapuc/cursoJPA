package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.dao.ClienteDAO;
import br.com.alura.dao.PedidoDAO;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;
import br.com.alura.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		popularBanco();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		Pedido pedido1 = new Pedido(cliente);
		Produto produto1 = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		Produto produto3 = produtoDAO.buscarPorId(3l);
		pedido1.adicionarItem(new ItemPedido(10, pedido1, produto1));
		pedido1.adicionarItem(new ItemPedido(40, pedido1, produto2));
		pedidoDAO.salvar(pedido1);
			
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido2, produto3));
		pedidoDAO.salvar(pedido2);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendas();
		System.out.println("Valor Total = " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		
		relatorio.forEach(System.out::println);
		
		em.close();
	}

	private static void popularBanco() {
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Categoria celulares = new Categoria("Celulares");
		Categoria videogames = new Categoria("Video Games");
		Categoria informatica = new Categoria("Informatica");
		
		em.getTransaction().begin();
		categoriaDAO.salvar(celulares);
		categoriaDAO.salvar(videogames);
		categoriaDAO.salvar(informatica);
		
		Produto celular = new Produto("Xiaomi RedMi", "Camera 40 MP", new BigDecimal("1500.0"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("5000.0"), videogames);
		Produto macbook = new Produto("Macbook", "MacBook Pro", new BigDecimal("8000.0"), informatica);
		
		produtoDAO.salvar(celular);
		produtoDAO.salvar(videogame);
		produtoDAO.salvar(macbook);
		
		Cliente cliente = new Cliente("Rodrigo", "1234556");
		
		clienteDAO.salvar(cliente);
		
		em.getTransaction().commit();		
		em.close();
	}
}
