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

			System.out.println(new java.sql.Date(reserva.getData().getTime()));
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
				"SELECT idReserva, dataReserva, c.nome, m.numero FROM Reserva "+
				"NATURAL JOIN Cliente c NATURAL JOIN Mesa m WHERE dataReserva = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setDate(1, new java.sql.Date(dataReserva.getTime()));
			
			resultSet = prepStmt.executeQuery();
			
				resultSet.first();
			
				reserva.setId(resultSet.getInt(1));
				reserva.setData(new java.util.Date(resultSet.getDate(2).getTime()));
				
				Cliente cliente = new Cliente();
				
				cliente.setNome(resultSet.getString(3));
				
				reserva.setCliente(cliente);
				
				Mesa mesa = new Mesa();
				
				mesa.setNumero(resultSet.getInt(4));
				
				reserva.setMesa(mesa);	
			
		} catch (SQLException e) {
			e.printStackTrace();
			reserva = null;
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
