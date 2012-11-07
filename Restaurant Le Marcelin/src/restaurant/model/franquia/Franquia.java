package restaurant.model.franquia;

import java.util.HashSet;

public class Franquia {
	
	private String nome;
	private String endereco;
	private String CEP;
	private String cidade;
	private char estado;
	private HashSet<Funcionario> funcionarios;
	
	public Franquia() {
		nome = "";
		endereco = "";
		CEP = "";
		cidade = "";
		estado = ' ';
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	public void adicionaFuncionario(Funcionario f){
		funcionarios.add(f);
	}
	
	public void removeFuncionario(Funcionario f){
		funcionarios.add(f);
	}
	
	
}
	

