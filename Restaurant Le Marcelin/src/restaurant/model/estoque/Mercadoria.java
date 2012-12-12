package restaurant.model.estoque;

public abstract class Mercadoria {
	
	
	private int id;
	private int codigo;
	private String nome;
	private float valor;
	private Estoque estoque;
	private Fornecedor fornecedor;
	
	public Mercadoria() {
		codigo = 0;
		nome = "";
		valor = 0.0f;
		estoque = new Estoque();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	abstract void definirEstoque(Estoque estoque);

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
	

}
