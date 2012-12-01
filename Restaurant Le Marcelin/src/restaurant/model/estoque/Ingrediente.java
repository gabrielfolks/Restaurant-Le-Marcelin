package restaurant.model.estoque;

import restaurant.util.Medida;

public class Ingrediente {
	
	private int quantidade;
	private Medida medida;
	private Insumo insumo;
	
	public Ingrediente() {
		quantidade = 0;
		medida = null;
		insumo = new Insumo();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = (quantidade > 0) ? quantidade : this.quantidade;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
	

}
