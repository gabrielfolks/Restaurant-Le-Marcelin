package restaurant.model.franquia;

import java.util.HashSet;

public class Franquia {
	
	private int id; 
	private String razao;
	private String fantasia;
	private String endereco;
	private String cep;
	private String cidade;
	private String estado;
	private String cnpj;
	
	public Franquia() {
		razao = "";
		fantasia = "";
		endereco = "";
		cep = "";
		cidade = "";
		estado = "";
		cnpj = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
	

