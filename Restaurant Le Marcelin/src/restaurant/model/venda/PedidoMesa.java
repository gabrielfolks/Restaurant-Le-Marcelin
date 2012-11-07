package restaurant.model.venda;

import restaurant.model.reserva.Mesa;

public class PedidoMesa extends Pedido {
	
	private Mesa mesa;
	
	public PedidoMesa() {
		mesa = new Mesa();
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}
