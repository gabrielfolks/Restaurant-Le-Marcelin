package restaurant.control.venda;

import java.util.Set;

import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pedido;

public class ComandaController {

	public void adicionarPedido(Pedido pedido, Comanda comanda) {
		comanda.adicionarPedido(pedido);
	}
	
	public void cancelarPedido(Pedido pedido, Comanda comanda) {
		comanda.removerPedido(pedido);
	}
	
	public void fecharComanda(Comanda comanda) {
		comanda.calcularValor();
	}
	
	public Comanda buscarComandaPorCodigo(String codigo) {
		return null;
	}
	
	public Set<Pedido> listarPedidos(Comanda comanda) {
		return comanda.getPedidos();
	}
	
	
	
}
