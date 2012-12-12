package restaurant.dao.jdbc;

import java.sql.*;

public class Conexao {
	private static String status = "";
	private static Connection conn = null;
	
	public static Connection getConexao() {
		try {
			String url = "jdbc:mysql://localhost:3306/restaurantlemarcelin";
			String usuario = "root";
			String senha = "";
			conn = DriverManager.getConnection(url, usuario, senha);
		}		
		
		catch(SQLException e){
			status = e.getMessage();
			System.out.println(e.getMessage());
		}catch(Exception e){
			status = e.getMessage();
		}
		return conn;
	}

	public static void fechar(){
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}


