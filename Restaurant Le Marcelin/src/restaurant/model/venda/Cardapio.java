package restaurant.model.venda;
import java.util.HashSet;

import restaurant.model.estoque.Produto;
import restaurant.util.DiaSemana;

public class Cardapio {
	
	private DiaSemana dia;
	private HashSet<Produto> produtos;
	
	public Cardapio() {
		dia = DiaSemana.DOM;
		produtos = new HashSet<>();
	}

	public DiaSemana getDia() {
		return dia;
	}

	public void setDia(DiaSemana dia) {
		this.dia = dia;
	}
	
	public void adicionaProduto(Produto p){
		produtos.add(p);
	}
	
	public void removeProduto(Produto p){
		produtos.remove(p);
	}
	
	public HashSet<Produto> listaProdutos(){
		return produtos;
	}

}
