package restaurant.control.venda;

import restaurant.dao.CardapioDAO;
import restaurant.dao.interfaces.ICardapioDAO;
import restaurant.model.venda.Cardapio;
import restaurant.util.DiaSemana;

public class CardapioController {

	ICardapioDAO cardapioDAO = new CardapioDAO();
	
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
