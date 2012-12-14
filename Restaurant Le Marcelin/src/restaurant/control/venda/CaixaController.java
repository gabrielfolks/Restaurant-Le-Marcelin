package restaurant.control.venda;

import java.util.ArrayList;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.ICaixaDAO;
import restaurant.dao.interfaces.IPagamentoDAO;
import restaurant.model.venda.Caixa;
import restaurant.model.venda.Pagamento;
 

public class CaixaController {

	private ICaixaDAO caixaDAO;
	private IPagamentoDAO pagDAO;
			
	public CaixaController(){
		
		caixaDAO = DAOFactory.createCaixaDAO();
		pagDAO = DAOFactory.createPagamentoDAO(caixaDAO.obtemCaixaCorrente());
	}
	
	public void abrirCaixa(float valorInicial) throws Exception{
		Caixa c = new Caixa(valorInicial);
		Caixa ca = getCaixaAtual();
		
		if (ca.isStatus())
			throw new Exception("O Caixa já está aberto");
		else{
			c.setStatus(true);
			caixaDAO.adicionar(c);
		}
	}
	
	public void fecharCaixa() throws Exception{
		Caixa c = getCaixaAtual();
		
		if (c.isStatus() == false){
			
			throw new Exception("O Caixa já está fechado!");
		}else{		
			c.setStatus(false);
			caixaDAO.atualizar(c);
		}
	}
	
	public Caixa getCaixaAtual(){
		
		return caixaDAO.obtemCaixaCorrente();
		
	}
	
	public ArrayList<Pagamento> listaTransacoes(){
		return pagDAO.listar(); 
	}
	
	
	
}
