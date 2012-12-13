package restaurant.util;

/**
 * 
 * @author Eduardo
 *  enum responsável por listar os tipos de medidas usados
 *  no software.
 */
public enum Medida {
	
	KG, // QUILO
	MG, // MILIGRAMA
	G, // GRAMA
	L, // LITRO
	ML; // MILILITRO

	@Override
	public String toString() {
		String medida = "";
		
		switch(this) {
			case KG:
				medida = "kg";
			case MG:
				medida = "mg";
			case G:
				medida = "g";
			case L:
				medida = "l";
			case ML:
				medida = "ml";
			default:
				medida = "";
		}
		
		return medida;
	}
	
}
