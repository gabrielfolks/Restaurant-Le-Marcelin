package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.dao.interfaces.IFranquiaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.franquia.Franquia;

public class FranquiaDAO implements IFranquiaDAO {

	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	
	protected FranquiaDAO(){}
	
	@Override
	public void adicionar(Franquia franquia) {
		connection = Conexao.getConexao();
		
		String sql = "{call insere_franquia(?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setString(1, franquia.getRazao());
			callStmt.setString(2, franquia.getFantasia());
			callStmt.setString(3, franquia.getCnpj());
			callStmt.setString(4, franquia.getEndereco());
			callStmt.setString(5, franquia.getCEP());
			callStmt.setString(6, franquia.getCidade());
			callStmt.setString(7, franquia.getEstado());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void atualizar(Franquia franquia) {
		connection = Conexao.getConexao();
		
		String sql = "{call altera_franquia(?,?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setInt(1, franquia.getId());
			callStmt.setString(2, franquia.getRazao());
			callStmt.setString(3, franquia.getFantasia());
			callStmt.setString(4, franquia.getCnpj());
			callStmt.setString(5, franquia.getEndereco());
			callStmt.setString(6, franquia.getCEP());
			callStmt.setString(7, franquia.getCidade());
			callStmt.setString(8, franquia.getEstado());
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
		
		
	}

	@Override
	public void remover(Franquia franquia) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Franquia WHERE id = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, franquia.getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}

	}

	@Override
	public Franquia pesquisar(String cnpj) {
		connection = Conexao.getConexao();
		
		Franquia franquia = new Franquia();
		
		String sql = "SELECT idFranquia, razao, fantasia, cnpj, endereco, cep, cidade, estado FROM Franquia WHERE cnpj = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			resultSet = prepStmt.executeQuery();
			
			resultSet.first();
			
			franquia.setId(resultSet.getInt(1));
			franquia.setRazao(resultSet.getString(2));
			franquia.setFantasia(resultSet.getString(3));
			franquia.setCnpj(resultSet.getString(4));
			franquia.setEndereco(resultSet.getString(5));
			franquia.setCEP(resultSet.getString(6));
			franquia.setCidade(resultSet.getString(7));
			franquia.setEstado(resultSet.getString(8));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
			
		return franquia;
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
