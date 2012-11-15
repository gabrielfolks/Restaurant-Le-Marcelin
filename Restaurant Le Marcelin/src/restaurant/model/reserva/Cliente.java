package restaurant.model.reserva;

public class Cliente {
	
	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cpf;
	
	public Cliente() {
		this.id = 0;
		this.nome = "";
		this.telefone = "";
		this.endereco = "";
		this.cpf = "";
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
