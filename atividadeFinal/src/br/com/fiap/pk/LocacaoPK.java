package br.com.fiap.pk;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class LocacaoPK implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Column(name="NUMLOCACAO") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlocacao;

	public int getCodigo() {
		return idlocacao;
	}

	public void setCodigo(int idlocacao) {
		this.idlocacao = idlocacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idlocacao;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocacaoPK other = (LocacaoPK) obj;
		if (idlocacao != other.idlocacao)
			return false;
		return true;
	}
	
}
