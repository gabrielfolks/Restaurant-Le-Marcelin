package restaurant.control.venda;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.ICardapioDAO;
import restaurant.model.venda.Cardapio;
import restaurant.util.DiaSemana;

public class CardapioController {

	ICardapioDAO cardapioDAO;
	
	public CardapioController() {
		cardapioDAO = DAOFactory.createCardapioDAO();
	}
	
	public void adicionarCardapio(Cardapio cardapio) {
		cardapioDAO.adicionar(cardapio);
	}
	
	public void atualizarCardapio(Cardapio cardapio) {
		cardapioDAO.atualizar(cardapio);
	}
	
	public void removerCardapio(Cardapio cardapio) {
		cardapioDAO.remover(cardapio);
	}
	
	public Cardapio buscarCardapio(DiaSemana dia) {
		return cardapioDAO.pesquisar(dia);
	}
	
}
