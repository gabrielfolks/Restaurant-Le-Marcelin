package restaurant.dao;

import java.util.ArrayList;
import java.util.Set;

import restaurant.dao.interfaces.IPedidoDAO;
import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pedido;

public class PedidoDAO implements IPedidoDAO {

	protected PedidoDAO(){}
	
	@Override
	public void adicionar(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Pedido> listarPedidosAbertos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido procurarPedido(int numeroPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pedido> listarPedidos(Comanda c) {
		// TODO Auto-generated method stub
		return null;
	}

}
