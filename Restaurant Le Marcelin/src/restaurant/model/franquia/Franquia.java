package restaurant.model.franquia;

import java.util.Set;

public class Franquia {
	
	private String razao;
	private String fantasia;
	private String endereco;
	private String cep;
	private String cidade;
	private char estado;
	private String cnpj;
	private Set<Funcionario> funcionarios;
	
	public Franquia() {
		razao = "";
		fantasia = "";
		endereco = "";
		cep = "";
		cidade = "";
		estado = ' ';
		cnpj = "";
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}
	
	public String getFantasia() {
		return fantasia;
	}
	
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return cep;
	}

	public void setCEP(String cEP) {
		cep = cEP;
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
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
	

