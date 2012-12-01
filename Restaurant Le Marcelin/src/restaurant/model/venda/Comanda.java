package restaurant.model.venda;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Comanda {
	
	private int id;
	private int codigo;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = (codigo > 0) ? id : this.codigo;
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
	public float calcularValor(){
		
		float valorComanda = 0;
		
		for (Pedido p : pedidos) 
			valorComanda += p.getValor();
		
		return valorComanda; 
	}
	
	public void adicionarPedido(Pedido p){
		pedidos.add(p);
	}
	
	public void removerPedido(Pedido p){
		pedidos.remove(p);
	}
 
	public Set<Pedido> getPedidos() {
		return Collections.unmodifiableSet(pedidos);
	}
}
