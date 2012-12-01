package restaurant.model.franquia;

import java.util.Date;

import restaurant.util.Cargo;

public class Funcionario {
	
	private int id;
	private String ctps;
	private String nome;
	private String telefone;
	private String endereco;
	private String cpf;
	private Date nascimento;
	private float salario;
	private float comissao;
	private Cargo cargo;
	private Login login;
	
	public Funcionario() {
		id = 0;
		ctps = "";
		nome = "";
		telefone = "";
		endereco = "";
		cpf = "";
		nascimento = new Date();
		salario = 0.0f;
		comissao = 0.0f;
		cargo = Cargo.ATENDENTE;
		login = new Login();		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = (salario > 0) ? salario : this.salario;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = (comissao > 0) ? comissao : this.comissao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	

}
