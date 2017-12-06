package br.com.fiap.programa;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.entity.Carro;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Locacao;
import br.com.fiap.helper.AluguelHelper;
import br.com.fiap.pk.LocacaoPK;

public class TestaAplicacao {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadefinal");
		EntityManager em = emf.createEntityManager();
		AluguelHelper dao = new AluguelHelper(em);

		try {
			//Cadastro dos clientes
			Cliente cliente = new Cliente(); 
			cliente.setNome("João Paulo da Silva");
			cliente.setCpf("123.456.789-10");
			
			Cliente cliente2 = new Cliente(); 
			cliente2.setNome("Antonio Carlos");
			cliente2.setCpf("101.236.554-09");
			
			Cliente cliente3 = new Cliente(); 
			cliente3.setNome("Andréia Silva");
			cliente3.setCpf("006.545.125-07");
			
			System.out.println("Cadastro de Clientes realizado com Sucesso !");
				
			//Cadastro  dos veículos
			Carro carro = new Carro();
			carro.setMarca("Honda");
			carro.setModelo("Civic");
			carro.setPlaca("DAO-5565");
			
			Carro carro1 = new Carro();
			carro1.setMarca("Volkswagem");
			carro1.setModelo("Polo");
			carro1.setPlaca("GIZ-5031");
			
			Carro carro2 = new Carro();
			carro2.setMarca("Fiat");
			carro2.setModelo("Uno");
			carro2.setPlaca("GGD-1859");

			System.out.println("Cadastro de veículos realizado com Sucesso !");
			
			//Cadastro da locação
			LocacaoPK pklocacao = new LocacaoPK(); 
			//pklocacao.setCodigo(01); 
			
			Locacao locacao = new Locacao(); 
			locacao.setLocacaoPK(pklocacao);
			locacao.setDataLocacao(new Date()); 
			locacao.setCliente(cliente);
			
			//Fazendo as associações
			locacao.getCarro().add(carro); 
			locacao.getCarro().add(carro1);
			locacao.getCarro().add(carro2);
			
			cliente.getLocacao().add(locacao);
			
			dao.salvar(cliente);
			dao.salvar(cliente2);
			dao.salvar(cliente3);
		
			System.out.println("Locação realizada com Sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}}}
