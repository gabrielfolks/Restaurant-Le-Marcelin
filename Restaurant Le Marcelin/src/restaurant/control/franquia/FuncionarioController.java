package restaurant.control.franquia;

import java.util.Set;

import restaurant.dao.FuncionarioDAO;
import restaurant.dao.interfaces.IFuncionarioDAO;
import restaurant.model.franquia.Funcionario;
import restaurant.util.Cargo;

public class FuncionarioController {

	IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarioDAO.adicionar(funcionario);
	}
	
	public void atualizarFuncionario(Funcionario funcionario) {
		funcionarioDAO.atualizar(funcionario);
	}

	public void removerFuncionario(Funcionario funcionario) {
		funcionarioDAO.remover(funcionario);
	}
	
	public Funcionario buscarFuncionario(String cpf) {
		return funcionarioDAO.pesquisarPorCPF(cpf);
	}
	
	public Set<Funcionario> buscarFuncionario(Cargo cargo) {
		return funcionarioDAO.pesquisarPorCargo(cargo);
	}
}
