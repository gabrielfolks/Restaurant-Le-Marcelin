package restaurant.dao.interfaces;

import java.util.ArrayList;

import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pagamento;

public interface IComandaDAO extends DAO<Comanda> {
	
	public Comanda buscar(int id);
	public ArrayList<Comanda> listar();
	

}
