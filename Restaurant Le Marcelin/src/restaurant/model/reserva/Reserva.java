package restaurant.model.reserva;

import java.util.Date;

public class Reserva {
	
	private int id;
	private Cliente cliente;
	private Mesa mesa;
	private Date data;
	
	public Reserva() {
		id = 0;
		mesa = new Mesa();
		cliente = new Cliente();
		data = new Date();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	
	

}
