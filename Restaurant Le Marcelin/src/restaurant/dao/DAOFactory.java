package restaurant.dao;

import restaurant.dao.interfaces.ICaixaDAO;
import restaurant.dao.interfaces.ICardapioDAO;
import restaurant.dao.interfaces.IClienteDAO;
import restaurant.dao.interfaces.IFornecedorDAO;
import restaurant.dao.interfaces.IFranquiaDAO;
import restaurant.dao.interfaces.IFuncionarioDAO;
import restaurant.dao.interfaces.IMesaDAO;
import restaurant.dao.interfaces.IPagamentoDAO;
import restaurant.dao.interfaces.IPedidoDAO;
import restaurant.dao.interfaces.IProdutoDAO;
import restaurant.dao.interfaces.IReservaDAO;
import restaurant.model.venda.Caixa;
import restaurant.model.venda.Comanda;

public class DAOFactory {

	private DAOFactory(){}
	
	public static ICardapioDAO createCardapioDAO() {
		return new CardapioDAO();
	}
	
	public static IClienteDAO createClienteDAO() {
		return new ClienteDAO();
	}
	
	public static IFornecedorDAO createFornecedorDAO() {
		return new FornecedorDAO();
	}
	
	public static IFranquiaDAO createFranquiaDAO() {
		return new FranquiaDAO();
	}
	
	public static IFuncionarioDAO createFuncionarioDAO() {
		return new FuncionarioDAO();
	}
	
	public static IMesaDAO createMesaDAO() {
		return new MesaDAO();
	}
	
	public static IPedidoDAO createPedidoDAO() {
		return new PedidoDAO();
	}
	
	public static IReservaDAO createReservaDAO() {
		return new ReservaDAO();
	}

	public static IProdutoDAO createProdutoDAO() {
		return new ProdutoDAO();
	}
	
	public static ICaixaDAO createCaixaDAO(){
		return new CaixaDAO();
	}
	
	public static IPagamentoDAO createPagamentoDAO(Caixa caixa){		
		return new PagamentoDAO(caixa);			
	}
	
	public static IPagamentoDAO createPagamentoDAO(Caixa caixa, Comanda comanda){
		
		PagamentoDAO pag = new PagamentoDAO(caixa);
		pag.setCom(comanda);
		
		return pag;
	}
}
