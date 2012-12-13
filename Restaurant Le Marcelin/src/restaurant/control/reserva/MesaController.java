package restaurant.control.reserva;

import java.util.List;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IMesaDAO;
import restaurant.model.reserva.Mesa;

public class MesaController {

	IMesaDAO mesaDAO;
	
	public MesaController() {
		mesaDAO = DAOFactory.createMesaDAO();
	}
	
	public void adicionarMesa(Mesa mesa) {
		mesaDAO.adicionar(mesa);
	}
	
	public void removerMesa(Mesa mesa) {
		mesaDAO.remover(mesa);
	}
	
	public void atualizarMesa(Mesa mesa) {
		mesaDAO.atualizar(mesa);
	}
	
	public Mesa pesquisarMesaPorNumero(int numeroMesa) {
		return mesaDAO.pesquisar(numeroMesa);
	}
	
	public List<Mesa> pesquisarMesaPorZona(String zona) {
		return mesaDAO.pesquisarPorZona(zona);
	}
	
}
