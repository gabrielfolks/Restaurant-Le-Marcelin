package restaurant.util;

public enum Cargo {
	
	GERENTE,
	ATENDENTE,
	GARCOM,
	ENTREGADOR;

	@Override
	public String toString() {
		String cargo = "";
		
		switch (this) {
			case GERENTE:
				cargo = "Gerente";
			case ATENDENTE:
				cargo = "Atendente";
			case GARCOM:
				cargo = "Garçom";
			case ENTREGADOR:
				cargo = "Entregador";
			
			default:
				cargo = "";
		}
			return cargo;
	}

}
