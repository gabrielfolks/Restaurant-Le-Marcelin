package restaurant.dao.interfaces;

import restaurant.model.franquia.Franquia;

public interface IFranquiaDAO extends DAO<Franquia> {
	Franquia pesquisar(String cnpj);
}
