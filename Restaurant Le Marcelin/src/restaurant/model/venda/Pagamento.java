package restaurant.model.venda;

import java.util.HashSet;

import restaurant.util.FormaPagamento;

public class Pagamento {
	
	private int idPagamento;
	

	private FormaPagamento formaPagamento;
	private int quantidadeParecelas;
	private HashSet<Comanda> comandas;
	
	public Pagamento() {
		idPagamento = 0;
		formaPagamento = FormaPagamento.DINHEIRO;
		quantidadeParecelas = 0;
		comandas = new HashSet<>();
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getQuantidadeParecelas() {
		return quantidadeParecelas;
	}
	
	public void setQuantidadeParecelas(int quantidadeParecelas) {
		this.quantidadeParecelas = quantidadeParecelas;
	}
	
	public void adicionaComanda(Comanda c){

		comandas.add(c);
	}	
	
	public void removeComanda(Comanda c){
		comandas.remove(c);
	}	
	
	/** 
	 * Percorre as comandas relacionadas, somando
	 * e retornando o total.  
	 * @return Soma do valor das comandas.
	 */
	public float obtemTotal(){
		float valor = 0;		
		for (Comanda c : comandas) 			
			valor += c.getValor();		
		return valor;
	}
	
	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	

}
