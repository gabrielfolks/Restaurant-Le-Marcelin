package restaurant.model.estoque;

import java.util.HashSet;

import restaurant.util.Medida;

public class Produto extends Mercadoria {

	private float tempoPreparo;
	private float quantMedida;
	private String medidaComercial;
	private float taxaDesconto;
	private boolean fabricacaoPropria;
	private HashSet<Ingrediente> ingredientes;
	
	public Produto() {
		quantMedida = 0;
		tempoPreparo = 0;
		medidaComercial = "";
		taxaDesconto = 1.0f;
		fabricacaoPropria = false;
		ingredientes = new HashSet<Ingrediente>();
	}
	
	public float getQuantMedida() {
		return quantMedida;
	}
	
	public void setQuantMedida(float quantMedida) {
		this.quantMedida = quantMedida;
	}
	
	public float getTempoPreparo() {
		return tempoPreparo;
	}
	
	public void setTempoPreparo(float tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	
	public String getMedidaComercial() {
		return medidaComercial;
	}
	
	public void setMedidaComercial(String medidaComercial) {
		this.medidaComercial = medidaComercial;
	}
	
	public float getTaxaDesconto() {
		return taxaDesconto;
	}
	
	public void setTaxaDesconto(float taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}
	
	public boolean isFabricacaoPropria() {
		return fabricacaoPropria;
	}
	public void setFabricacaoPropria(boolean fabricacaoPropria) {
		this.fabricacaoPropria = fabricacaoPropria;
	}	
	
	@Override
	/**
	 * Este metodo calcula a partir da disponibilidade de seus insumos a quantidade
	 * disponível para fabricação no estoque.
	 */
	public void definirEstoque(Estoque estoque) {
		
	}
	
	
	public void adicionaInsumo(Insumo i, int quantidade, Medida medida){
		ingredientes.add(new Ingrediente());
	}
	
	public void removeInsumo(Insumo i){
		ingredientes.remove(new Ingrediente());
	}
}
	
	
	
	

