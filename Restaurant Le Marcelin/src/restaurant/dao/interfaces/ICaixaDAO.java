package restaurant.dao.interfaces;

import restaurant.model.venda.Caixa;

public interface ICaixaDAO extends DAO<Caixa> {
	
	public Caixa obtemCaixaCorrente();	

}
