package restaurant.model.estoque;

import restaurant.util.Medida;

public class Insumo extends Mercadoria {
	
	private Medida unidadeMedida;
	
	public Insumo() {
		this.unidadeMedida = null;
	}

	@Override
	void definirEstoque(Estoque estoque) {
		// TODO Auto-generated method stub		
	}

	public Medida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(Medida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	
	
	
	
	
	

}
