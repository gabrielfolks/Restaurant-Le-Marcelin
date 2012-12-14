package restaurant.dao;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.dao.interfaces.ICaixaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.venda.Caixa;

public class CaixaDAO implements ICaixaDAO {

	private final String INSERE_CAIXA = "Call Insere_Caixa(?, ?, ?, ?, ?)";
	private final String ALTERA_CAIXA = "Call Altera_Caixa(?, ?, ?, ?, ?)";
	private final String DELETA_CAIXA = "DELETE FROM Caixa where codigo = ?";
	private final String SELECIONA_CAIXA_CORRENTE = "SELECT codigo, dia, valorInicial, valor, status FROM Caixa ORDER BY dia desc LIMIT 1";
	
	@Override
	public void adicionar(Caixa c) {
	
		Connection con;
		CallableStatement cstm;
		
		
		try {
			
			con = Conexao.getConexao();
			cstm = con.prepareCall(INSERE_CAIXA);
			
			cstm.setInt(1, c.getCodigo());
			cstm.setDate(2, new java.sql.Date(c.getDia().getTime()));
			cstm.setFloat(3, c.getValor());
			cstm.setFloat(4, c.getValorInicial());
			cstm.setBoolean(5, c.isStatus());
			
			cstm.executeUpdate();
			
			con.close();
			cstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

	}

	@Override
	public void atualizar(Caixa c) {
		
		Connection con;
		CallableStatement cstm;
		
		
		try {
			
			con = Conexao.getConexao();
			cstm = con.prepareCall(ALTERA_CAIXA);
			
			cstm.setInt(1, c.getCodigo());
			cstm.setDate(2, new java.sql.Date(c.getDia().getTime()));
			cstm.setFloat(3, c.getValor());
			cstm.setFloat(4, c.getValorInicial());
			cstm.setBoolean(5, c.isStatus());
			
			cstm.executeUpdate();
			
			con.close();
			cstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	@Override
	public void remover(Caixa c) {
		
		Connection con = Conexao.getConexao();
		PreparedStatement stm;
		try {
			
			stm = con.prepareStatement(DELETA_CAIXA);
			stm.setInt(1, c.getCodigo());			
			stm.executeUpdate();
			
			con.close();
			stm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public Caixa obtemCaixaCorrente() {
		// TODO Auto-generated method stub
		Caixa c = null;
		
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(SELECIONA_CAIXA_CORRENTE);
			ResultSet rs = stm.executeQuery();
			
			
			if( rs.next() ){
				c = new Caixa(0.0f);
				c.setCodigo(rs.getInt("codigo"));
				c.setDia(new java.util.Date(rs.getDate("dia").getTime()));
				c.setValor(rs.getFloat("valor"));
				c.setValorInicial(rs.getFloat("valorInicial"));				
			}			
			
			con.close();
			stm.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return c;
	}

	
}
