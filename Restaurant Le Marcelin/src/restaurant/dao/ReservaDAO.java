package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import restaurant.dao.interfaces.IReservaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;

class ReservaDAO implements IReservaDAO {

	private Connection connection;
	private PreparedStatement prepStmt;
	private ResultSet resultSet;
	private CallableStatement callStmt;
	
	protected ReservaDAO(){}
	
	@Override
	public void adicionar(Reserva reserva) {
		connection = Conexao.getConexao();
		
		String sql = "{call insere_reserva (?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setDate(1, new java.sql.Date(reserva.getData().getTime()));
			callStmt.setInt(2, reserva.getCliente().getId());
			callStmt.setInt(3, reserva.getMesa().getId());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void atualizar(Reserva reserva) {
		connection = Conexao.getConexao();
		
		String sql = "{call altera_reserva(?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
			
			callStmt.setInt(1, reserva.getId());
			callStmt.setDate(2, new java.sql.Date(reserva.getData().getTime()));
			callStmt.setInt(3, reserva.getCliente().getId());
			callStmt.setInt(4, reserva.getMesa().getId());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
		
	}

	@Override
	public void remover(Reserva reserva) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Reserva WHERE idReserva = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, reserva.getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}
	
	@Override
	public Reserva procurarPorData(Date dataReserva) {
		connection = Conexao.getConexao();
		
		Reserva reserva = new Reserva();
		
		String sql = 
				"SELECT r.idReserva, r.data, c.idCliente, c.nome, c.telefone, c.endereco, c.cpf"+ 
				"m.idMesa, m.numero, m.zona, m.fumante, m.lugares FROM Reserva r"+ 
				"NATURAL JOIN Cliente c NATURAL JOIN Mesa m WHERE data = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setDate(1, new java.sql.Date(dataReserva.getTime()));
			
			resultSet = prepStmt.executeQuery();
			
			while (resultSet.next()) {
				reserva.setId(resultSet.getInt(1));
				reserva.setData(new java.util.Date(resultSet.getDate(2).getTime()));
				
				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt(3));
				cliente.setNome(resultSet.getString(4));
				cliente.setTelefone(resultSet.getString(5));
				cliente.setEndereco(resultSet.getString(6));
				cliente.setCpf(resultSet.getString(6));
				
				reserva.setCliente(cliente);
				
				Mesa mesa = new Mesa();
				
				mesa.setId(resultSet.getInt(7));
				mesa.setNumero(resultSet.getInt(8));
				mesa.setZona(resultSet.getString(9));
				mesa.setFumante(resultSet.getBoolean(10));
				mesa.setLugares(resultSet.getInt(11));
				
				reserva.setMesa(mesa);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
		
		return reserva;
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
