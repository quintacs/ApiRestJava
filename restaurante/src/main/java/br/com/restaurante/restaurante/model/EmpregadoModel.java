package br.com.restaurante.restaurante.model;

public class EmpregadoModel {

	private  long id = 0;
	private  String nome = "";
	private  String funcao = "";
	
	public EmpregadoModel(long id, String nome, String funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		EmpregadoModel other = (EmpregadoModel) obj;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
