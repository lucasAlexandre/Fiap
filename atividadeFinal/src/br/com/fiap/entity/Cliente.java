package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID") 
	private int idcliente;
	
	@Column(name="NOME") 
	private String nome;
	
	@Column(name="CPF") 
	private String cpf;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
	private Set<Locacao> locacao = new LinkedHashSet<Locacao>();

	public int getId() {
		return idcliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setId(int idcliente) {
		this.idcliente = idcliente;
	}
	public Set<Locacao> getLocacao() {
		return locacao;
	}
	public void setLocacao(Set<Locacao> locacao) {
		this.locacao = locacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
