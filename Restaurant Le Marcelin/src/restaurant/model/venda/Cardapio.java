package restaurant.model.venda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import restaurant.model.estoque.Produto;
import restaurant.util.DiaSemana;

public class Cardapio {
	
	private DiaSemana dia;
	private List<Produto> produtos;
	
	public Cardapio() {
		dia = DiaSemana.DOM;
		produtos = new ArrayList<>();
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
	
	public List<Produto> listaProdutos(){
		return produtos;
	}

	public Produto getProduto(int indice) {
		return produtos.get(indice);
	}

}
