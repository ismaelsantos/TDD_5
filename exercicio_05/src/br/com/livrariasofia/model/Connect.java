package br.com.livrariasofia.model;
import java.sql.*;

public class Connect {

	public static void main(String[] args) throws SQLException {
		Connection conx = null;
		Statement stmt = null;
		// String Driver="";
		String URL = "jdbc:mysql://localhost:3306/";
		String db = "mydb";
		String u_name = "root";
		String u_pwd = "admin";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conx = DriverManager.getConnection(URL + db, u_name, u_pwd);
			
			if (conx != null) {
				System.out.println("Connection has established");
				stmt = conx.createStatement();
				
				ResultSet rs = stmt.executeQuery("SELECT * FROM livro");
				System.out.println(rs.toString());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				conx.close();
			} catch (Exception ex) {
				System.out.println("closing err");
			}
		}

	}

}