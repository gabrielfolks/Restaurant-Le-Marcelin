package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import restaurant.dao.interfaces.IFuncionarioDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.franquia.Franquia;
import restaurant.model.franquia.Funcionario;
import restaurant.model.franquia.Login;
import restaurant.util.Cargo;

public class FuncionarioDAO implements IFuncionarioDAO {

	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	
	protected FuncionarioDAO(){}
	
	@Override
	public void adicionar(Funcionario funcionario) {
		connection = Conexao.getConexao();
		
		String sql = "{call insere_funcionario(?,?,?,?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setInt(1, funcionario.getLocalTrabalho().getId());
			callStmt.setString(2, funcionario.getCtps());
			callStmt.setString(3, funcionario.getNome());
			callStmt.setString(4, funcionario.getEndereco());
			callStmt.setString(5, funcionario.getCpf());
			callStmt.setDate(6, new java.sql.Date (funcionario.getNascimento().getTime()));
			callStmt.setFloat(7, funcionario.getSalario());
			callStmt.setFloat(8, funcionario.getComissao());
			callStmt.setString(9, funcionario.getCargo().toString());
			callStmt.setInt(10, funcionario.getLogin().getId());

			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		connection = Conexao.getConexao();
		
		String sql = "{call altera_funcionario (?,?,?,?,?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setInt(1, funcionario.getId());
			callStmt.setInt(2, funcionario.getLocalTrabalho().getId());
			callStmt.setString(3, funcionario.getCtps());
			callStmt.setString(4, funcionario.getNome());
			callStmt.setString(5, funcionario.getEndereco());
			callStmt.setString(6, funcionario.getCpf());
			callStmt.setDate(7, new java.sql.Date (funcionario.getNascimento().getTime()));
			callStmt.setFloat(8, funcionario.getSalario());
			callStmt.setFloat(9, funcionario.getComissao());
			callStmt.setString(10, funcionario.getCargo().toString());
			callStmt.setInt(11, funcionario.getLogin().getId());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void remover(Funcionario funcionario) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, funcionario.getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public Funcionario pesquisarPorCPF(String cpf) {
		connection = Conexao.getConexao();
		
		Funcionario funcionario = new Funcionario();
		
		String sql = "SELECT idFuncionario, ctps, nome, endereco, " +
				"cpf, nascimento, salario, comissao, cargo "+
				"FROM Funcionario WHERE cpf = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setString(1, cpf);
			
			resultSet = prepStmt.executeQuery();
			
			resultSet.first();
			
			funcionario.setId(resultSet.getInt(1));
			funcionario.setCtps(resultSet.getString(2));
			funcionario.setNome(resultSet.getString(3));
			funcionario.setEndereco(resultSet.getString(4));
			funcionario.setCpf(resultSet.getString(5));
			funcionario.setNascimento(new java.util.Date(resultSet.getDate(6).getTime()));
			funcionario.setSalario(resultSet.getFloat(7));
			funcionario.setComissao(resultSet.getFloat(8));
			funcionario.setCargo(Cargo.valueOf(resultSet.getString(9)));
				
		} catch (SQLException e) {
			e.printStackTrace();
			funcionario = null;
		} finally {
			fecharTudo();
		}
		
		
		return funcionario;
	}

	@Override
	public Set<Funcionario> pesquisarPorCargo(Cargo cargo) {
		connection = Conexao.getConexao();
		
			
		String sql = "SELECT idFuncionario, ctps, nome, endereco, " +
				"cpf, nascimento, salario, comissao, cargo, " +
				"l.idLogin, l.usuario, fq.idFranquia, fq.razao, fq.cnpj" +
				"FROM Funcionario " +
				"NATURAL JOIN Login l NATURAL JOIN Franquia fq" +
				"WHERE cargo = ?";
		
		Set<Funcionario> funcionarios = new HashSet<>();
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setString(1, cargo.toString());
			
			resultSet = prepStmt.executeQuery();
			
			while(resultSet.next()) {
				funcionarios.add(criarFuncionario());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
		
		
		return funcionarios;
	}
	

	private Funcionario criarFuncionario() {
		
		Funcionario funcionario = new Funcionario();
		
		try {
			funcionario.setId(resultSet.getInt(1));
			funcionario.setCtps(resultSet.getString(2));
			funcionario.setNome(resultSet.getString(3));
			funcionario.setEndereco(resultSet.getString(4));
			funcionario.setCpf(resultSet.getString(5));
			funcionario.setNascimento(new java.util.Date(resultSet.getDate(6).getTime()));
			funcionario.setSalario(resultSet.getFloat(7));
			funcionario.setComissao(resultSet.getFloat(8));
			funcionario.setCargo(Cargo.valueOf(resultSet.getString(9)));
			
			Login login = new Login();
			
			login.setId(resultSet.getInt(10));
			login.setUsuario(resultSet.getString(11));
			
			funcionario.setLogin(login);
			
			Franquia localTrabalho = new Franquia();
			
			localTrabalho.setId(resultSet.getInt(12));
			localTrabalho.setRazao(resultSet.getString(13));
			localTrabalho.setCnpj(resultSet.getString(14));
			
			funcionario.setLocalTrabalho(localTrabalho);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionario;
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
