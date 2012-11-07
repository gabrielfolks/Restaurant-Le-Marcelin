package restaurant.model.venda;
import java.util.HashSet;

import restaurant.model.estoque.Produto;
import restaurant.util.Dia;

public class Cardapio {
	
	private Dia dia;
	private HashSet<Produto> produtos;
	
	public Cardapio() {
		dia = Dia.DOM;
		produtos = new HashSet<>();
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
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
