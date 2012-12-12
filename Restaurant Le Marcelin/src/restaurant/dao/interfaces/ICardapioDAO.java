package restaurant.dao.interfaces;

import restaurant.model.venda.Cardapio;
import restaurant.util.DiaSemana;

public interface ICardapioDAO extends DAO<Cardapio>{

	Cardapio pesquisar(DiaSemana dia);
}
