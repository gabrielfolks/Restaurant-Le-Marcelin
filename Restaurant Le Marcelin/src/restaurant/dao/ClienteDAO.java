package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.dao.interfaces.IClienteDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.reserva.Cliente;

public class ClienteDAO implements IClienteDAO {

	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	private ResultSet resultSet;
	private Connection connection;
	
	protected ClienteDAO(){}
	
	@Override
	public void adicionar(Cliente cliente) {
		connection = Conexao.getConexao();
			
		String sql = "{call insere_cliente (?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setString(1, cliente.getNome());
			callStmt.setString(2, cliente.getTelefone());
			callStmt.setString(3, cliente.getEndereco());
			callStmt.setString(4, cliente.getCpf());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		connection = Conexao.getConexao();
		
		String sql = "{call altera_cliente (?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setInt(1, cliente.getId());
			callStmt.setString(2, cliente.getNome());
			callStmt.setString(3, cliente.getTelefone());
			callStmt.setString(4, cliente.getEndereco());
			callStmt.setString(5, cliente.getCpf());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void remover(Cliente cliente) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Cliente WHERE idCliente = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, cliente.getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public Cliente procurarClientePorCPF(String cpf) {
		connection = Conexao.getConexao();
		Cliente cliente = new Cliente();
				
		String sql = "SELECT idCliente, nome, telefone, endereco, cpf FROM Cliente WHERE cpf = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setString(1, cpf);
			
			resultSet = prepStmt.executeQuery();
			resultSet.first();
			
			cliente.setId(resultSet.getInt(1));
			cliente.setNome(resultSet.getString(2));
			cliente.setTelefone(resultSet.getString(3));
			cliente.setEndereco(resultSet.getString(4));
			cliente.setCpf(resultSet.getString(5));
			
		} catch (SQLException e) {
			System.err.println("Não há resultados para esta busca");
			cliente = null;
		} finally {
			fecharTudo();
		}
		
		return cliente;
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
