package restaurant.control.estoque;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IFornecedorDAO;
import restaurant.model.estoque.Fornecedor;

public class FornecedorController {
	
	private IFornecedorDAO fornecedorDAO;
	
	public FornecedorController(){
		fornecedorDAO = DAOFactory.createFornecedorDAO();
	}
	
	public void adicionarFornecedor(Fornecedor f){		
		fornecedorDAO.adicionar(f);
	}
		
	public void removerFornecedor(Fornecedor f){
		fornecedorDAO.remover(f);
	}
	
	public void atualizarFornecedor(Fornecedor f){
		fornecedorDAO.atualizar(f);
	}
	
	public Fornecedor pesquisarFornecedorPorCNPJ(String cnpj){
		return fornecedorDAO.pesquisar(cnpj);
	}

}
