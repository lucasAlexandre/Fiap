package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.pk.LocacaoPK;

@Entity
@Table(name="locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L; 

	@EmbeddedId
	private LocacaoPK locacaoPK;

	@Temporal(value=TemporalType.TIMESTAMP) 
	@Column(name="DATALOCACAO")
	private Date dataLocacao;

	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="IDCLIENTE") 
	private Cliente cliente;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="locacao") 
	private Set<Carro> carros = new LinkedHashSet<Carro>();

	
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente; 
	}
	public LocacaoPK getLocacaoPK() {
		return locacaoPK;
	}
	public void setLocacaoPK(LocacaoPK locacaoPK) {
		this.locacaoPK = locacaoPK;
	}
	public Set<Carro> getCarro() {
		return carros;
	}
	public void setCarro(Set<Carro> carro) {
		this.carros = carro;
	}
}
