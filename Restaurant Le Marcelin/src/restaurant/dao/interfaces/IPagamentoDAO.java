package restaurant.dao.interfaces;

import java.util.ArrayList;

import restaurant.model.venda.Caixa;
import restaurant.model.venda.Pagamento;

public interface IPagamentoDAO extends DAO<Pagamento> {
	
	public ArrayList<Pagamento> listar(Caixa c);	
	

}
