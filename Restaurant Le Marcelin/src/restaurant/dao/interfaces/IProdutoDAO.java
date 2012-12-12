package restaurant.dao.interfaces;

import restaurant.model.estoque.Produto;

public interface IProdutoDAO extends DAO<Produto> {

	Produto pesquisar(int codigo);
	
}
