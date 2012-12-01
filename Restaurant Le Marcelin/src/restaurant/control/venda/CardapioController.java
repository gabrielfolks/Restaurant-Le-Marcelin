package restaurant.control.venda;

import restaurant.model.estoque.Produto;
import restaurant.model.venda.Cardapio;
import restaurant.util.DiaDaSemana;

public class CardapioController {

	public void adicionarCardapio(Cardapio cardapio) {
		
	}
	
	public void removerCardapio (Cardapio cardapio) {
		
	}
	
	public void atualizarCardapio (Cardapio cardapio) {
		
	}
	
	public Cardapio buscarCardapioPorDia(DiaDaSemana dia) {
		return null;
	}
	
	public void adicionarProduto(Cardapio cardapio, Produto produto) {
		cardapio.adicionarProduto(produto);
	}
	
	public void removerProduto(Cardapio cardapio, Produto produto) {
		cardapio.removerProduto(produto);
	}
}
