package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carros")
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")
	private int id;

	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumns({@JoinColumn(name="NUMLOCACAO",referencedColumnName="NUMLOCACAO")})
	private Locacao locacao;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="MODELO")
	private String modelo;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="MARCA")
	private String marca;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="PLACA")
	private String placa;

	public int getId() { return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
	
}

