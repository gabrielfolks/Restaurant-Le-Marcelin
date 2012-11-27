package restaurant.dao.interfaces;

import restaurant.model.reserva.Cliente;

public interface IClienteDAO extends DAO<Cliente> {

	Cliente procurarClientePorCPF(String cpf);
	
}
