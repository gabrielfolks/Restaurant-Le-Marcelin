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
				diaDaSemana = "Domingo";
			
			case SEG:
				diaDaSemana = "Segunda-feira";
			
			case TER:
				diaDaSemana = "Terça-feira";
			
			case QUA:
				diaDaSemana = "Quarta-feira";
				
			case QUI:
				diaDaSemana = "Quinta-feira";
			
			case SEX:
				diaDaSemana = "Sexta-feira";
				
			case SAB:
				diaDaSemana = "Sábado";
			
			default:
				diaDaSemana = "";
		}
		
		
		return diaDaSemana;
	}
			
			
			

}
