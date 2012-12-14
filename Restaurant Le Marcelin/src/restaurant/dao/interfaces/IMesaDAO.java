package restaurant.dao.interfaces;

import java.util.List;
import java.util.Set;

import restaurant.model.reserva.Mesa;

public interface IMesaDAO extends DAO<Mesa> {

	Mesa pesquisar(int numeroMesa);
	List<Mesa> pesquisarPorZona(String zona);
	
}
