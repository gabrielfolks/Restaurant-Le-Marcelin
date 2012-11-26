package restaurant.dao.interfaces;

import java.util.Set;

import restaurant.model.franquia.Funcionario;
import restaurant.util.Cargo;

public interface IFuncionarioDAO extends DAO<Funcionario> {

	Funcionario pesquisarPorCPF(String cpf);
	Set<Funcionario> pesquisarPorCargo(Cargo cargo);
	
}
