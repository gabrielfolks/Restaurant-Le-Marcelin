package restaurant.model.cliente;

import java.util.Date;

public class Reserva {
	
	private Cliente cliente;
	private Date data;
	
	public Reserva() {
		cliente = new Cliente();
		data = new Date();
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
	
	

}
