package restaurant.model.venda;

import java.util.Date;

import restaurant.model.reserva.Cliente;

public class PedidoEntrega extends Pedido {
	
	private Date previsaoEntrega;
	private float taxaEntrega;
	private Cliente cliente;
	
	public PedidoEntrega() {
		previsaoEntrega = new Date();
	}

	public Date getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public float getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(float taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
