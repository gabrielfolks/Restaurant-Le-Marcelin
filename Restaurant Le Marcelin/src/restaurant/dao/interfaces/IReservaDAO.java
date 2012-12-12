package restaurant.dao.interfaces;

import java.util.Date;
import java.util.Set;

import restaurant.model.reserva.Reserva;

public interface IReservaDAO extends DAO<Reserva> {

	Set<Reserva> procurarPorData(Date dataReserva);
	
}
