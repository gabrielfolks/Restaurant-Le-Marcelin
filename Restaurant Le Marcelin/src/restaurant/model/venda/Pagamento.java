package restaurant.model.venda;

import java.util.HashSet;

import restaurant.util.Forma;

public class Pagamento {
	
	private Forma formaPagamento;
	private int quantidadeParecelas;
	private HashSet<Comanda> comandas;
	
	public Pagamento() {
		formaPagamento = Forma.DINHEIRO;
		quantidadeParecelas = 0;
		comandas = new HashSet<>();
	}

	public Forma getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Forma formaPagamento) {
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
	 * 
	 * @return Soma do valor das comandas.
	 */
	public float obtemTotal(){
		return 0;
	}
	

}
