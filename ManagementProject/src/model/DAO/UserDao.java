package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Product;
import entities.User;
import utils.SQLUtil;

public class UserDao {
	private final ConnectionManager manager;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public UserDao() {
		manager = new ConnectionManagerImpl();
	}
	
	public User checkLogin(String email, String password) {
		Connection connection = manager.getConnection();
		String query = "SELECT * FROM user WHERE email=? AND pass=?";
		User user = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (!rs.next()) {
				return null;
			}
			user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("pass"), rs.getString("fullname"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, pst, connection);
		}
		return user;
	}
}
