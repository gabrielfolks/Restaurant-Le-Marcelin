package restaurant.control.franquia;

import restaurant.dao.DAOFactory;
import restaurant.dao.FranquiaDAO;
import restaurant.dao.interfaces.IFranquiaDAO;
import restaurant.model.franquia.Franquia;

public class FranquiaController {

	IFranquiaDAO franquiaDAO;
	
	public FranquiaController() {
		franquiaDAO = DAOFactory.createFranquiaDAO();
	}
	
	public void adicionarFranquia(Franquia franquia) {
		franquiaDAO.adicionar(franquia);
	}

	public void atualizarFranquia(Franquia franquia) {
		franquiaDAO.atualizar(franquia);
	}

	public void removerFranquia(Franquia franquia) {
		franquiaDAO.remover(franquia);
	}

	public Franquia pesquisar(String cnpj) {
		return franquiaDAO.pesquisar(cnpj);
	}

	
}
