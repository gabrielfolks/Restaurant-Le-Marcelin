package restaurant.model.estoque;

public class Estoque {
	
	private int qtdeMax;
	private int qtdeMin;
	private int qtdeItens;
	
	public Estoque() {
		qtdeItens = 0;
		qtdeMax = 0;
		qtdeMin = 0;
	}

	public int getQtdeMax() {
		return qtdeMax;
	}

	public void setQtdeMax(int qtdeMax) {
		this.qtdeMax = qtdeMax;
	}

	public int getQtdeMin() {
		return qtdeMin;
	}

	public void setQtdeMin(int qtdeMin) {
		this.qtdeMin = qtdeMin;
	}

	public int getQtdeItens() {
		return qtdeItens;
	}

	public void setQtdeItens(int qtdeItens) {
		this.qtdeItens = qtdeItens;
	}
	
	

}
