package restaurant.control.reserva;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IClienteDAO;
import restaurant.model.reserva.Cliente;

public class ClienteController {

	IClienteDAO clienteDAO = DAOFactory.createClienteDAO();
	
	public void adicionar(Cliente cliente) {
		clienteDAO.adicionar(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		clienteDAO.atualizar(cliente);
	}
	
	public void remover(Cliente cliente) {
		clienteDAO.remover(cliente);
	}
	
	public Cliente pesquisarPorCPF(String cpf) {
		return clienteDAO.procurarClientePorCPF(cpf);
	}
	
}
