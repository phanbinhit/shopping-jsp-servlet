package bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionManagerImpl;
import entities.Product;
import utils.SQLUtil;

public class ProductBo {
	
	private final ConnectionManagerImpl manager;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ProductBo() {
		manager = new ConnectionManagerImpl();
	}
	
	public Product getMaxPrice() {
		Product product = null;
		Connection connection = manager.getConnection();
		String query = "select * from product\r\n"
				+ "where id_branch is not null\r\n"
				+ "order by price desc\r\n"
				+ "limit 1";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			if (!rs.next()) {
				return null;
			} else {
				product = new Product(rs.getString("title"), rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, st, connection);
		}
		return product;
	}
}
