package restaurant.model.reserva;

public class Mesa {
	
	private int id;
	private int numero;
	private String zona;
	private boolean fumante;
	private int lugares;
	
	public Mesa() {
		numero = 0;
		zona = "";
		fumante = false;
		lugares = 0;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public boolean isFumante() {
		return fumante;
	}

	public void setFumante(boolean fumante) {
		this.fumante = fumante;
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}
	
	

	
}
