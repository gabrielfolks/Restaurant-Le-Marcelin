package restaurant.control.venda;

import java.util.ArrayList;
import java.util.HashSet;

import restaurant.dao.ComandaDAO;
import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IComandaDAO;
import restaurant.dao.interfaces.IPedidoDAO;
import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pedido;

public class ComandaController {
	
	private IComandaDAO comandaDAO;
	private PedidoController pedidoControl;
		
	public ComandaController(){
		comandaDAO = DAOFactory.createComandaDAO();
		pedidoControl = new PedidoController();
	}
	
	public void adicionarComanda(Comanda c){
		comandaDAO.adicionar(c);
	}
	
	public void adicionarComanda(Pedido p, Comanda c){		
		c.adicionaPedido(p);
	}
	
	public void fecharComanda(Comanda c){
		
	}
	
	public Comanda buscarComanda(int codigo){
		return comandaDAO.buscar(codigo);
	}
	
	public HashSet<Pedido> listarPedidos(Comanda c){
		ArrayList<Pedido> pedidos = pedidoControl.buscarPedidosAbertos(c);
		HashSet<Pedido> pedidosComanda = new HashSet<>();
		
		for (Pedido pedido : pedidos) {
			pedidosComanda.add(pedido);
		}
		
		return pedidosComanda;
		
	}
	

}
