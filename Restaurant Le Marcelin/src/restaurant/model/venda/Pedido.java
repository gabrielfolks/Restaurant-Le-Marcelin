package restaurant.model.venda;

import java.util.Date;
import java.util.HashSet;

public class Pedido {
	
	private int numero;
	private float valor;
	private Date previsao;
	private HashSet<ItemPedido> itens;
	
	public Pedido() {
		numero = 0;
		valor = 0.0f;
		previsao = new Date();
		itens = new HashSet<>();		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
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
