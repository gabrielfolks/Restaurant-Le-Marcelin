package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import restaurant.dao.interfaces.IMesaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.reserva.Mesa;

public class MesaDAO implements IMesaDAO {

	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	
	protected MesaDAO(){}
	
	//(in p_numero int, in p_zona int, in p_f BOOLEAN, in p_lug int)
	
	@Override
	public void adicionar(Mesa mesa) {
		connection = Conexao.getConexao();
		
		String sql = "{call insere_mesa (?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
		
			callStmt.setInt(1, mesa.getNumero());
			callStmt.setString(2, mesa.getZona());
			callStmt.setBoolean(3, mesa.isFumante());
			callStmt.setInt(4, mesa.getLugares());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void atualizar(Mesa mesa) {
		connection = Conexao.getConexao();
		
		String sql = "{call altera_mesa(?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setInt(1, mesa.getId());
			callStmt.setInt(2, mesa.getNumero());
			callStmt.setString(3, mesa.getZona());
			callStmt.setBoolean(4, mesa.isFumante());
			callStmt.setInt(5, mesa.getLugares());
						
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void remover(Mesa mesa) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Mesa WHERE idMesa = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
		
			prepStmt.setInt(1, mesa.getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Mesa pesquisar(int numeroMesa) {
		connection = Conexao.getConexao();
		
		Mesa mesa = new Mesa();
		
		String sql = "SELECT idMesa, numero, zona, fumante, lugares FROM Mesa WHERE numero = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, numeroMesa);
			
			resultSet = prepStmt.executeQuery();
			
			resultSet.first();
			
			mesa = criarMesa();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
		return mesa;
	}

	@Override
	public Set<Mesa> pesquisarPorZona(String zona) {
		connection  = Conexao.getConexao();
		
		Set<Mesa> mesas = new HashSet<>();
		
		String sql = "SELECT idMesa, numero, zona, fumante, lugares FROM Mesa WHERE zona = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
		
			prepStmt.setString(1, zona);
			
			resultSet = prepStmt.executeQuery();
			
			while (resultSet.next()) {
				mesas.add(criarMesa());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
		
		return mesas;
	}

	private Mesa criarMesa() {
		
		Mesa mesa = new Mesa();
		
		try {
			mesa.setId(resultSet.getInt(1));
			mesa.setNumero(resultSet.getInt(2));
			mesa.setZona(resultSet.getString(3));
			mesa.setFumante(resultSet.getBoolean(4));
			mesa.setLugares(resultSet.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mesa;
	}
	
	private void fecharTudo() {
		try {
			if (connection != null)
				connection.close();
			if (resultSet != null)
				resultSet.close();
			if (prepStmt != null)
				prepStmt.close();
			if (callStmt != null)
				callStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
