package restaurant.control.franquia;

import restaurant.dao.FranquiaDAO;
import restaurant.dao.interfaces.IFranquiaDAO;
import restaurant.model.franquia.Franquia;

public class FranquiaController {

	IFranquiaDAO franquiaDAO = new FranquiaDAO();
	
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
