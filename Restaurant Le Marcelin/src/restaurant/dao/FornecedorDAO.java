package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.dao.interfaces.IFornecedorDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.estoque.Fornecedor;

public class FornecedorDAO implements IFornecedorDAO {

	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	private ResultSet resultSet;
	private Connection connection;
	
	protected FornecedorDAO(){}
		
	@Override
	public void adicionar(Fornecedor fornecedor) {
		connection = Conexao.getConexao();
		
		String sql = "{call insere_fornecedor (?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setString(1, fornecedor.getNome());
			callStmt.setString(2, fornecedor.getCnpj());
			callStmt.setString(3, fornecedor.getTelefone());
			callStmt.setString(4, fornecedor.getEndereco());
			callStmt.setString(5, fornecedor.getCep());
			callStmt.setString(6, fornecedor.getRazaoSocial());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
		
		
	}

	@Override
	public void atualizar(Fornecedor fornecedor) {
		connection = Conexao.getConexao();
			
		String sql = "{call altera_fornecedor(?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
						
			callStmt.setString(1, fornecedor.getNome());
			callStmt.setString(2, fornecedor.getCnpj());
			callStmt.setString(3, fornecedor.getTelefone());
			callStmt.setString(4, fornecedor.getEndereco());
			callStmt.setString(5, fornecedor.getCep());
			callStmt.setString(6, fornecedor.getRazaoSocial());
	
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void remover(Fornecedor fornecedor) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Fornecedor WHERE idFornecedor = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, fornecedor.getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}

	}

	@Override
	public Fornecedor pesquisar(String cnpj) {
		connection = Conexao.getConexao();
		
		Fornecedor fornecedor = new Fornecedor();
		
		String sql = "SELECT idFornecedor, nome, cnpj, telefone, endereco, cep, razaoSocial " +
				"FROM Fornecedor WHERE cnpj = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setString(1, cnpj);
			
			resultSet = prepStmt.executeQuery();
			
			resultSet.first();
			
			fornecedor.setId(resultSet.getInt(1));
			fornecedor.setNome(resultSet.getString(2));
			fornecedor.setCnpj(resultSet.getString(3));
			fornecedor.setTelefone(resultSet.getString(4));
			fornecedor.setEndereco(resultSet.getString(5));
			fornecedor.setCep(resultSet.getString(6));
			fornecedor.setRazaoSocial(resultSet.getString(7));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fornecedor;
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
