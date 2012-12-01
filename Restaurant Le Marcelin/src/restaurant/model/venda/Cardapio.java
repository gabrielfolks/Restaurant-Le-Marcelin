package restaurant.model.venda;
import java.util.HashSet;
import java.util.Set;

import restaurant.model.estoque.Produto;
import restaurant.util.DiaDaSemana;

public class Cardapio {
	
	private DiaDaSemana dia;
	private Set<Produto> produtos;
	
	public Cardapio() {
		dia = DiaDaSemana.DOM;
		produtos = new HashSet<>();
	}

	public DiaDaSemana getDia() {
		return dia;
	}

	public void setDia(DiaDaSemana dia) {
		this.dia = dia;
	}
	
	public void adicionarProduto(Produto p){
		produtos.add(p);
	}
	
	public void removerProduto(Produto p){
		produtos.remove(p);
	}
	
	public Set<Produto> listaProdutos(){
		return produtos;
	}

}
