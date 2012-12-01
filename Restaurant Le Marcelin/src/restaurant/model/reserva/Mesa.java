package restaurant.model.reserva;

public class Mesa {
	
	private int id;
	private String zona;
	private boolean fumante;
	private int lugares;
	
	public Mesa() {
		id = 0;
		zona = "";
		fumante = false;
		lugares = 0;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (id > 0) ? id : this.id;
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
		this.lugares = (lugares > 0) ? id : this.id;
	}
	
	

	
}
