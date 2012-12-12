package restaurant.dao.interfaces;

import restaurant.model.estoque.Fornecedor;

public interface IFornecedorDAO extends DAO<Fornecedor> {

	Fornecedor pesquisar(String cnpj);
}
