package restaurant.model.venda;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Pedido {
	
	private int id;
	private float valor;
	private Date previsao;
	private Set<ItemPedido> itens;
	
	public Pedido() {
		id = 0;
		valor = 0.0f;
		previsao = new Date();
		itens = new HashSet<>();		
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

	public Date getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Date previsao) {
		this.previsao = previsao;
	}
	
	public void adicionaPedido(ItemPedido ip){
		itens.add(ip);
	}
	
	public void removePedido(ItemPedido ip){		
		itens.remove(ip);		
	}
	
	

}
