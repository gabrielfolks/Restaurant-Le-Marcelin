package restaurant.control.venda;

import restaurant.model.reserva.Cliente;
import restaurant.model.venda.Pedido;

public class DeliveryController {

	public void adicionarPedido(Cliente cliente, Pedido pedido) {
		new PedidoController().criarPedido(pedido, cliente);
	}
	
	public void cancelarPedido(Cliente cliente, Pedido pedido) {
		
	}
	
}
