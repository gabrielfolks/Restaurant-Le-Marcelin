package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import restaurant.dao.interfaces.IComandaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.venda.Comanda;

public class ComandaDAO implements IComandaDAO {

	private final String INSERE_COMANDA = "CALL INSERE_COMANDA( ?, ?, ? )";
	private final String ALTERA_COMANDA = "CALL ALTERA_COMANDA( ? , ? , ? )";
	private final String SELECT_COMANDA = "SELECT * FROM COMANDA where codigo = ? order by data desc LIMIT 1";
	private final String SELECT_COMANDA_DATA = "SELECT * FROM COMANDA where data = ?";
	private final String DELETE_COMANDA = "DELETE FROM COMANDA where codigo = ? ";
	Connection con;
		
	@Override
	public void adicionar(Comanda c) {
		try {
			con = Conexao.getConexao();
			CallableStatement stm = con.prepareCall(INSERE_COMANDA);
			stm.setInt(1, c.getCodigo());
			stm.setFloat(2, c.getValor());
			stm.setDate(3, new Date(System.currentTimeMillis()));
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Comanda c) {
		
		try {
			con = Conexao.getConexao();
			CallableStatement stm = con.prepareCall(INSERE_COMANDA);
			stm.setInt(1, c.getCodigo());
			stm.setFloat(2, c.getValor());			
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Comanda c) {
		try {
			con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(DELETE_COMANDA);
			
			stm.setInt(1, c.getCodigo());
			
			stm.executeUpdate();
			con.close();			
			stm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Comanda buscar(int id) {
		Comanda c = null;
		try {
			
			con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(SELECT_COMANDA);
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if (rs.next()){
				c.setCodigo(rs.getInt("codigo"));
				c.setValor(rs.getFloat("valor"));
			}
			
			con.close();
			stm.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public ArrayList<Comanda> listar() {
		ArrayList<Comanda> comandas = null;
		return comandas;
	}

	@Override
	public ArrayList<Comanda> listar(Date data) {
		ArrayList<Comanda> comandas = null;
		
		try {
			con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement(SELECT_COMANDA_DATA);
			stm.setDate(1, data);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Comanda c = new Comanda();
				c.setCodigo(rs.getInt("codigo"));
				c.setValor(rs.getFloat("valor"));
				
				comandas.add(c);
			}
			
			con.close();
			stm.close();
			rs.close();			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return comandas;
	}

}
