package restaurant.control.venda;

import java.sql.Date;
import java.util.ArrayList;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IPedidoDAO;
import restaurant.model.reserva.Cliente;
import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pedido;
import restaurant.model.venda.PedidoEntrega;

public class PedidoController {

	private IPedidoDAO pedDAO;
	private ComandaController cc;
	
	public PedidoController(){
		pedDAO = DAOFactory.createPedidoDAO();
		cc = new ComandaController();
	}
	
	public void criarPedido(Pedido p, Comanda c){		
		c.adicionaPedido(p);
		cc.adicionarComanda(c);
		
		pedDAO.adicionar(p);
	}
	
	public void criarPedido(PedidoEntrega p, Cliente c){
		
	}
	
	public ArrayList<Pedido> buscarPedidosAbertos(Date hoje){
		return null;
	}
	
	public ArrayList<Pedido> buscarPedidosAbertos(Comanda c){
		return null;
	}
}
