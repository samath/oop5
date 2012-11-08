package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreSQLUtils {
	
	private static final String SERVER = "mysql-user.stanford.edu";
	private static final String ACCOUNT = "ccs108samath";
	private static final String PASSWORD = "";
	private static final String DATABASE = "c_cs108_samath";
	
	public static List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Connection conn = newConnection();
			ResultSet rs = executeQuery(conn, "SELECT * FROM products ORDER BY name;");
			rs.beforeFirst();
			while(rs.next()) {
				products.add(new Product(rs.getString("productid"), rs.getString("name"),
										rs.getString("imagefile"), rs.getDouble("price")));
			}
			conn.close();
		} catch (SQLException e) { /* empty */ }
		return products;
	}
	
	public static Product getProductByID(String ID) {
		if(ID == null) return null;
		Product p = null;
		try {
			Connection conn = newConnection();
			String query = "SELECT * FROM products WHERE productid = \'" + ID + "\';";
			ResultSet rs = executeQuery(conn, query);
			if(rs == null || !rs.first()) return null;
			p = new Product(rs.getString("productid"), rs.getString("name"),
								rs.getString("imagefile"), rs.getDouble("price"));
			conn.close();
		} catch (SQLException e) { return null; }
		return p;
	}
	
	private static ResultSet executeQuery(Connection conn, String query) {
		if(conn == null) return null;
		ResultSet rs;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery("USE " + DATABASE);
			rs = stmt.executeQuery(query);
		} catch (SQLException e) { rs = null; }
		return rs;
		
	}
	
	private static Connection newConnection() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + SERVER, ACCOUNT, PASSWORD);
			return conn;
		} catch (SQLException e) { return null; }
	}

}
