package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer.Form;
import java.util.ArrayList;

import restaurant.dao.interfaces.IPagamentoDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.venda.Caixa;
import restaurant.model.venda.Comanda;
import restaurant.model.venda.Pagamento;
import restaurant.util.Forma;

public class PagamentoDAO implements IPagamentoDAO {

	private Caixa c;
	private Comanda com;
	
	private final String INSERE_PAGAMENTO = "CALL INSERE_PAGAMENTO(? , ? , ? , ?)";
	private final String ALTERA_PAGAMENTO = "CALL ALTERA_PAGAMENTO(?, ? , ? , ? )";
	private final String DELETA_PAGAMENTO = "DELETE FROM Pagamento Where idPagamento = ?";
	private final String SELECT_PAGAMENTO = "SELECT * FROM pagamento Where idCaixa = ? ";
	
	public PagamentoDAO(Caixa c){
		this.c = c;
		com = new Comanda();		
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
			
			
			con.close();
			stm.close();
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
			
			con.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(Pagamento p) {
		try{
			Connection con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(DELETA_PAGAMENTO);
			stm.setInt(1, p.getIdPagamento());
			
			stm.executeUpdate();
			
			con.close();
			stm.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}		
		
	}

	@Override
	public void setComanda(Comanda com) {
		this.com = com;		
	}

	@Override
	public Comanda getComanda() {
		// TODO Auto-generated method stub
		return this.com;
	}


	@Override
	public ArrayList<Pagamento> listar() {
		ArrayList<Pagamento> pagamentos = null;
		
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(SELECT_PAGAMENTO);
			stm.setInt(1, c.getCodigo());
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Pagamento p = new Pagamento();
				
				p.setIdPagamento(rs.getInt("idPagamento"));
				String forma = rs.getString("formaPagamento");
				
				for (Forma f : Forma.values()) {
					if (forma.equals(f.toString()))
						p.setFormaPagamento(f);						
				}				
				p.setQuantidadeParecelas(rs.getInt("quantidadeParcelas"));
				pagamentos.add(p);
			}
			
			con.close();
			stm.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return pagamentos;
	}

	

}
