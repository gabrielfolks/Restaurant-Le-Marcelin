package restaurant.model.estoque;

import java.util.HashSet;
import java.util.Set;

public class Fornecedor {
	
	private String nome;
	private String cnpj;
	private String telefone;
	private String endereco;
	private String razaoSocial;
	private String cep;
	private Set<Mercadoria> mercadorias;
	
	public Fornecedor() {
		nome = "";
		cnpj = "";
		telefone = "";
		endereco = "";
		razaoSocial = "";
		cep = "";
		mercadorias = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void adicionaMercadoria(Mercadoria m){
		mercadorias.add(m);
	}
	
	public void removeMercadoria(Mercadoria m){
		mercadorias.remove(m);
	}
	
	public HashSet<Mercadoria> listaMercadorias(){
		return mercadorias;
	}
	
	
}	
	


