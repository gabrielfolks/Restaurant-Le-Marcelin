package restaurant.util;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class MascarasCampos {

	private MascarasCampos() {}
	
	public static MaskFormatter getCEPMask() {
		MaskFormatter cepMask = null;
		
		try {
			cepMask = new MaskFormatter("#####-###");
			cepMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cepMask;
	}
		
	public static MaskFormatter getCNPJMask() {
		MaskFormatter cnpjMask = null;
		
		try {
			cnpjMask = new MaskFormatter("##.###.###/####-##");
			cnpjMask.setValidCharacters("0123456789");			
			cnpjMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cnpjMask;
	}
	
	
	
	public static MaskFormatter getCPFMask() {
		MaskFormatter cpfMask = null;
		
		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		return cpfMask;
	}
	
	public static MaskFormatter getDinheiroMask() {
		MaskFormatter dinheiroMask = null;
				
		try {
			dinheiroMask = new MaskFormatter("R$ ##,##");
			dinheiroMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dinheiroMask;
	}
	
	public static MaskFormatter getTelefoneMask() {
		MaskFormatter telefoneMask = null;
		try {
			telefoneMask = new MaskFormatter("(##) #####-####");
			telefoneMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return telefoneMask;
	}
	
}
