package br.com.restaurante.restaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MensagemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String conteudo;
	
	public MensagemModel() {}
	
	public MensagemModel(long id, String conteudo) {
		super();
		this.id = id;
		this.conteudo = conteudo;
	}
	public MensagemModel(String conteudo) {
		this.conteudo = conteudo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		MensagemModel other = (MensagemModel) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
