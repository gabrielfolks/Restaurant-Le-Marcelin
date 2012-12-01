package restaurant.model.venda;

import java.util.HashSet;
import java.util.Set;

public class Comanda {
	
	private int id;
	private float valor;
	private Set<Pedido> pedidos;
	
	public Comanda() {
		id = 0;
		valor = 0.0f;
		pedidos = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (id > 0) ? id : this.id;
	}


	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = (valor > 0) ? valor : this.valor;
	}
	
	/**
	 * Percorre a lista de pedidos e calcula seu valor total.
	 * @return o valor da soma dos pedidos.
	 */
	public float calculaValor(){
		return 0; 
	}
	
	public void adicionaPedido(Pedido p){
		pedidos.add(p);
	}
	
	public void removePedido(Pedido p){
		pedidos.remove(p);
	}
 
}
