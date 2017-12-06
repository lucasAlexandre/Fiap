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
			//Definindo o cliente
			Cliente cliente = new Cliente(); 
			cliente.setId(10);
			cliente.setNome("João Paulo da Silva");
			
				
			//Defnindo o pedido
			LocacaoPK pklocacao = new LocacaoPK(); 
			pklocacao.setCodigo(100); 
			
			Locacao locacao = new Locacao(); 
			locacao.setLocacaoPK(pklocacao);
			locacao.setDataLocacao(new Date()); 
			locacao.setCliente(cliente);
			
			//Definindo dois itens
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

			
			//Fazendo as associacÌ§oÌƒes
			locacao.getCarro().add(carro); 
			locacao.getCarro().add(carro1);
			locacao.getCarro().add(carro2);
			
			cliente.getLocacao().add(locacao);
			
			dao.salvar(cliente);
			
			
			System.out.println("Aluguel incluído com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
	}
}