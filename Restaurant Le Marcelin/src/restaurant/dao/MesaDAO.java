package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.dao.interfaces.IMesaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.reserva.Mesa;

public class MesaDAO implements IMesaDAO {

	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	
	protected MesaDAO(){}
	
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
		
		String sql = "{call altera_mesa(?,?,?,?)}";
		
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
	public void remover(Mesa mesa) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Mesa WHERE numero = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
		
			prepStmt.setInt(1, mesa.getNumero());
			
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
			
			if (resultSet.first())
				mesa = criarMesa();
			else 
				mesa = null;
		
		} catch (SQLException e) {
			e.printStackTrace();
			mesa = null;
		}
	
		return mesa;
	}

	@Override
	public List<Mesa> pesquisarPorZona(String zona) {
		connection  = Conexao.getConexao();
		
		List<Mesa> mesas = new ArrayList<>();
		
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
