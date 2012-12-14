package restaurant.dao.interfaces;

import java.util.ArrayList;
import java.util.Set;

import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pedido;

public interface IPedidoDAO extends DAO<Pedido> {

	Set<Pedido> listarPedidosAbertos();
	Pedido procurarPedido(int numeroPedido);
	ArrayList<Pedido> listarPedidos(Comanda c);
}
