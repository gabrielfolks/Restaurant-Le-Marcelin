package restaurant.util;

public enum FormaPagamento {
	
		DINHEIRO,
		DEBITO,
		CREDITO,
		VR,
		CHEQUE;
		
		@Override
		public String toString() {
			String formaPagamento = "";
			
			switch(this) {
			
				case DINHEIRO:
					formaPagamento = "Dinheiro";
				case DEBITO:
					formaPagamento = "D�bito";
				case CREDITO:
					formaPagamento = "Cr�dito";
				case VR:
					formaPagamento = "VR";
				case CHEQUE:
					formaPagamento = "Cheque";
				default:
					formaPagamento = "";
			
			}
			
			return formaPagamento;
		}
		
}
