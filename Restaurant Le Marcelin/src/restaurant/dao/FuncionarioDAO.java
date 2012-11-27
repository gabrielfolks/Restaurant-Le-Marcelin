package restaurant.dao;

import java.util.Set;

import restaurant.dao.interfaces.IFuncionarioDAO;
import restaurant.model.franquia.Funcionario;
import restaurant.util.Cargo;

public class FuncionarioDAO implements IFuncionarioDAO {

	protected FuncionarioDAO(){}
	
	@Override
	public void adicionar(Funcionario funcionario) {
			
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		
	}

	@Override
	public void remover(Funcionario funcionario) {
		
	}

	@Override
	public Funcionario pesquisarPorCPF(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Funcionario> pesquisarPorCargo(Cargo cargo) {
		// TODO Auto-generated method stub
		return null;
	}

}
