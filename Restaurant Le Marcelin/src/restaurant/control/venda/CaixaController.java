package restaurant.control.venda;

import java.util.ArrayList;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.ICaixaDAO;
import restaurant.model.venda.Caixa;
import restaurant.model.venda.Pagamento;
 

public class CaixaController {

	private ICaixaDAO dao = DAOFactory.createCaixaDAO();
			
	public void abrirCaixa(float valorInicial) throws Exception{
		Caixa c = new Caixa(valorInicial);
		Caixa ca = getCaixaAtual();
		
		if (ca.isStatus())
			throw new Exception("O Caixa já está aberto");
		else{
			c.setStatus(true);
			dao.adicionar(c);
		}
	}
	
	public void fecharCaixa() throws Exception{
		Caixa c = getCaixaAtual();
		
		if (c.isStatus() == false){
			
			throw new Exception("O Caixa já está fechado!");
		}else{		
			c.setStatus(false);
			dao.atualizar(c);
		}
	}
	
	public Caixa getCaixaAtual(){
		
		return dao.obtemCaixaCorrente();
		
	}
	
	public ArrayList<Pagamento> listaTransacoes(){
		return null;
	}
	
	
	
}
