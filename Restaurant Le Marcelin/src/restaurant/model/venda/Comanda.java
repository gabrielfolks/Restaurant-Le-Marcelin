package restaurant.model.venda;

import java.util.HashSet;

public class Comanda {
	
	private int codigo;
	private float valor;
	private HashSet<Pedido> pedidos;
	
	public Comanda() {
		codigo = 0;
		valor = 0.0f;
		pedidos = new HashSet<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
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
