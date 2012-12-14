package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import restaurant.dao.interfaces.IComandaDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.venda.Comanda;

public class ComandaDAO implements IComandaDAO {

	private final String INSERE_COMANDA = "CALL INSERE_COMANDA( ?, ?, ? )";
	private final String ALTERA_COMANDA = "CALL ALTERA_COMANDA( ? , ? , ? )";
	private final String SELECT_COMANDA = "SELECT * FROM COMANDA where codigo = ? order by data desc LIMIT 1";
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
	public void remover(Comanda entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comanda buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comanda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
