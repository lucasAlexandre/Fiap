package br.com.fiap.programa;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.impl.GenericDao;
import br.com.fiap.inte.DAO;
import br.com.fiap.util.JpaUtil;

public class TestGeneric {

	public static void main(String[] args) {
		
		Clientes client = new Clientes();
		client.setNome("Lucas Alexandre Correa");
		client.setEmail("lucorrea90@gmail.com");
		
		
		Pedidos pedido = new Pedidos();
		pedido.setData(new Date());
		pedido.setDescricao("Petição para rodar em produção");
		pedido.setValor(2.50);
		
		GenericDao<Clientes> daoCliente = new GenericDao<>(Clientes.class);
		
		GenericDao<Pedidos> daoPedido = new GenericDao<>(Pedidos.class);
		
		daoCliente.adicionar(client);
		daoPedido.adicionar(pedido);
		
		System.out.println("Buscando cliente com o ID 1"+daoCliente.buscar(1).getNome());
		System.out.println("Buscando pedido com o ID 1"+daoPedido.buscar(1).getDescricao());
		
		
		
		/*System.out.println("Atualizando Cliente com o ID 1 antes" +daoCliente.buscar(1).getNome());
		
		client.setNome("Lucas Alexandre Correa da Silva");
		daoCliente.atualizar(client);
		
		System.out.println("Atualizando Cliente com o ID 1 antes" +daoCliente.buscar(1).getNome());*/
		
		daoCliente.remover(client);
		daoPedido.remover(pedido);
		
		
		
		
		
	}

}
