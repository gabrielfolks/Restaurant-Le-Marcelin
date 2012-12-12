package restaurant.dao.interfaces;

import java.util.Set;

import restaurant.model.estoque.Produto;

public interface IProdutoDAO extends DAO<Produto> {

	Set<Produto> pesquisarPorNome(String nome);
	
}
