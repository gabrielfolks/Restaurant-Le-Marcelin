package restaurant.control.estoque;

import java.util.ArrayList;
import java.util.HashSet;

import restaurant.model.estoque.Fornecedor;

public class FornecedorController {
	
	private HashSet<Fornecedor> fornecedores;
	
	public FornecedorController(){
		fornecedores = new HashSet<>();
	}
	
	public void adicionarFornecedor(Fornecedor f){		
		fornecedores.add(f);
	}
	
	public void removerFornecedor(Fornecedor f){
		fornecedores.remove(f);
	}
	
	public void atualizarFornecedor(Fornecedor f){
		
	}
	
	public ArrayList<Fornecedor> buscarFornecedor(String nome){
		return null;
	}

}
