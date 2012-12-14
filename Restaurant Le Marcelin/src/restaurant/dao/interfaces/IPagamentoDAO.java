package restaurant.dao.interfaces;

import java.util.ArrayList;

import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pagamento;

public interface IPagamentoDAO extends DAO<Pagamento> {	
	
	public void setComanda(Comanda com);
	public Comanda getComanda();
	public ArrayList<Pagamento> listar();
	

}
