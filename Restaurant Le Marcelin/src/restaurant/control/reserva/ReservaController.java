package restaurant.control.reserva;

import java.util.Date;
import java.util.Set;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.IReservaDAO;
import restaurant.model.reserva.Reserva;

public class ReservaController {

	IReservaDAO reservaDAO = DAOFactory.createReservaDAO();
	
	public void adicionar(Reserva reserva) {
		reservaDAO.adicionar(reserva);
	}
	
	public void remover(Reserva reserva) {
		reservaDAO.remover(reserva);
	}
	
	public void atualizar(Reserva reserva) {
		reservaDAO.atualizar(reserva);
	}
	
	public Set<Reserva> procurarPorData(Date dataReserva) {
		return reservaDAO.procurarPorData(dataReserva);
	}
	
}
