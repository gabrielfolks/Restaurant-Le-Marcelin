package restaurant.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import restaurant.dao.interfaces.IProdutoDAO;
import restaurant.dao.jdbc.Conexao;
import restaurant.model.estoque.Fornecedor;
import restaurant.model.estoque.Produto;

public class ProdutoDAO implements IProdutoDAO {

	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement prepStmt;
	private CallableStatement callStmt;
	
	protected ProdutoDAO(){}

	@Override
	public void adicionar(Produto produto) {
		connection = Conexao.getConexao();
		
		String sql = "{call insere_produto(?,?,?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
		
			callStmt.setInt(1, produto.getCodigo());
			callStmt.setString(2, produto.getNome());
			callStmt.setFloat(3, produto.getValor());
			callStmt.setInt(4, produto.getFornecedor().getId());
			callStmt.setDate(5, new java.sql.Date(produto.getTempoPreparo().getTime()));
			callStmt.setFloat(6, produto.getQuantMedida());
			callStmt.setString(7, produto.getMedidaComercial().toString());
			callStmt.setFloat(8, produto.getTaxaDesconto());
			callStmt.setBoolean(9, produto.isFabricacaoPropria());
			
			callStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public void atualizar(Produto produto) {
		connection = Conexao.getConexao();
		
		String sql = "{call altera_produto(?,?,?,?,?,?,?,?,?,?)}";
		
		try {
			callStmt = connection.prepareCall(sql);
		
			callStmt.setInt(1, produto.getId());
			callStmt.setInt(2, produto.getCodigo());
			callStmt.setString(3, produto.getNome());
			callStmt.setFloat(4, produto.getValor());
			callStmt.setInt(5, produto.getFornecedor().getId());
			callStmt.setDate(6, new java.sql.Date(produto.getTempoPreparo().getTime()));
			callStmt.setFloat(7, produto.getQuantMedida());
			callStmt.setString(8, produto.getMedidaComercial().toString());
			callStmt.setFloat(9, produto.getTaxaDesconto());
			callStmt.setBoolean(10, produto.isFabricacaoPropria());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}

	}

	@Override
	public void remover(Produto produto) {
		connection = Conexao.getConexao();
		
		String sql = "DELETE FROM Produto WHERE idMercadoria = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, produto.getId());
	
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharTudo();
		}
	}

	@Override
	public Produto pesquisar(int codigo) {
		connection = Conexao.getConexao();
		
		Produto produto = new Produto();
		
		String sql = "SELECT idMercadoria, codigo, nome, valor," +
				" tempoPreparo, quantMedida, medidaComercial, taxaDesconto, fabricacaoPropria," +
				" f.idFornecedor, f.nome " +
				"FROM Produto NATURAL JOIN Mercadoria NATURAL JOIN Fornecedor f WHERE codigo = ?";
		
		try {
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setInt(1, codigo);
			
			resultSet = prepStmt.executeQuery();
			
			resultSet.first();
			
			produto.setId(resultSet.getInt(1));
			produto.setCodigo(resultSet.getInt(2));
			produto.setNome(resultSet.getString(3));
			produto.setValor(resultSet.getFloat(4));
			produto.setTempoPreparo(new java.util.Date(resultSet.getDate(5).getTime()));
			produto.setQuantMedida(resultSet.getFloat(6));
			produto.setMedidaComercial(resultSet.getString(7));
			produto.setTaxaDesconto(resultSet.getFloat(8));
			produto.setFabricacaoPropria(resultSet.getBoolean(9));
			
			Fornecedor fornecedor = new Fornecedor();
			
			fornecedor.setId(resultSet.getInt(10));
			fornecedor.setNome(resultSet.getString(11));
			
			produto.setFornecedor(fornecedor);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return produto;
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
