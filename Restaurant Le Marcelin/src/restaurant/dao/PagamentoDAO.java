package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import restaurant.dao.interfaces.IPagamentoDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.venda.Caixa;
import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pagamento;

public class PagamentoDAO implements IPagamentoDAO {

	private Caixa c;
	private Comanda com;
	
	private final String INSERE_PAGAMENTO = "CALL INSERE_PAGAMENTO(? , ? , ? , ?)";
	private final String ALTERA_PAGAMENTO = "CALL ALTERA_PAGAMENTO(?, ? , ? , ? )";
	private final String DELETA_PAGAMENTO = "DELETE FROM Pagamento WHERE idPagamento = ?";
	private final String SELECIONA_PAGAMENTO = "SELECT * FROM Pagamento WHERE idCaixa = ?";
	
	public PagamentoDAO(Caixa c){
		this.c = c;
		com = new Comanda();		
	}		
	
	public Comanda getCom() {
		return com;
	}

	public void setCom(Comanda com) {
		this.com = com;
	}

	@Override
	public void adicionar(Pagamento p) {		
		
		try {
			Connection con = Conexao.getConexao();
			CallableStatement stm = con.prepareCall(INSERE_PAGAMENTO);
			stm.setString(1, p.getFormaPagamento().toString());
			stm.setInt(2, p.getQuantidadeParecelas());
			stm.setInt(3, com.getCodigo());
			stm.setInt(4, c.getCodigo());
			
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
				
	}

	@Override
	public void atualizar(Pagamento p) {
		try {
			Connection con = Conexao.getConexao();
			CallableStatement stm = con.prepareCall(ALTERA_PAGAMENTO);
			stm.setString(1, p.getFormaPagamento().toString());
			stm.setInt(2, p.getQuantidadeParecelas());
			stm.setInt(3, com.getCodigo());
			stm.setInt(4, c.getCodigo());
			
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	@Override
	public void remover(Pagamento p) {
		
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement stm = con.prepareCall(DELETA_PAGAMENTO);
			//stm.setInt(1, p.);		
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public ArrayList<Pagamento> listar(Caixa c) {		
		
		ArrayList<Pagamento> pagamentos = null;
		
		try {
			
			Connection con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(SELECIONA_PAGAMENTO);
			stm.setInt(1, c.getCodigo());
			
			ResultSet rs = stm.executeQuery();
			pagamentos = new ArrayList<>();
			
			while(rs.next()){
				Pagamento p = new Pagamento();
				
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return pagamentos;
	}

	

}
