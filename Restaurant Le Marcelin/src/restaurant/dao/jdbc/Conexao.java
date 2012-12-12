package restaurant.dao.jdbc;

import java.sql.*;

public class Conexao {
	public static String status = "";
	public static Connection conn = null;
	
	public static Connection getConexao() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/restaurantlemarcelin";
			conn = DriverManager.getConnection(url, "root", "");
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


