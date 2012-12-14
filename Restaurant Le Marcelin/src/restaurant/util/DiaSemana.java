package restaurant.util;

public enum DiaSemana {
	
	DOM,
	SEG,
	TER,
	QUA,
	QUI,
	SEX,
	SAB;

	@Override
	public String toString() {
		String diaDaSemana = "";

		switch(this) {
		case DOM:
			return diaDaSemana = "Domingo";
		case SEG:
			return diaDaSemana = "Segunda-feira";
		case TER:
			return diaDaSemana = "Terça-feira";

		case QUA:
			return diaDaSemana = "Quarta-feira";

		case QUI:
			return diaDaSemana = "Quinta-feira";

		case SEX:
			return diaDaSemana = "Sexta-feira";

		case SAB:
			return diaDaSemana = "Sábado";

		default:
			return diaDaSemana = "";
		}


	}
			
			
			

}
