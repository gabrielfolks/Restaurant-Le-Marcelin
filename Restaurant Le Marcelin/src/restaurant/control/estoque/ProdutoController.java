package restaurant.control.estoque;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IProdutoDAO;
import restaurant.model.estoque.Produto;

public class ProdutoController {
	
	private IProdutoDAO produtoDAO;
	
	public ProdutoController() {
		produtoDAO = DAOFactory.createProdutoDAO();
	}
	
	public void adicionarProduto(Produto produto){		
		produtoDAO.adicionar(produto);
	}
	
	public void removerProduto(Produto produto){
		produtoDAO.remover(produto);
	}
	
	public void atualizarProduto(Produto produto){
		produtoDAO.atualizar(produto);
	}
	
	public Produto pesquisarProduto(int codigo){
		return produtoDAO.pesquisar(codigo);
	}

}
