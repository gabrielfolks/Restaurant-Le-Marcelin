package restaurant.model.venda;

import java.util.HashSet;

import restaurant.util.Forma;

public class Pagamento {
	
	private Forma formaPagamento;
	private int quantidadeParcelas;
	private HashSet<Comanda> comandas;
	
	public Pagamento() {
		formaPagamento = Forma.DINHEIRO;
		quantidadeParcelas = 0;
		comandas = new HashSet<>();
	}

	public Forma getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Forma formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = (quantidadeParcelas > 0) ? quantidadeParcelas : this.quantidadeParcelas;
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
