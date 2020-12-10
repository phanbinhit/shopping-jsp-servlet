package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Branch;
import entities.Product;
import utils.SQLUtil;

public class ProductDaoImpl{
	
	private final ConnectionManager manager;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ProductDaoImpl() {
		manager = new ConnectionManagerImpl();
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		Connection connection = manager.getConnection();
		String query = "select product.id_product, product.title tt_product, product.quantity, product.price, branch.title tt_branch\r\n"
				+ "from product\r\n"
				+ "join branch on product.id_branch = branch.id_branch";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Product product = new Product(
						rs.getInt("id_product")
						, rs.getString("tt_product")
						, rs.getString("tt_branch")
						, rs.getInt("quantity")
						, rs.getDouble("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, st, connection);
		}
		return products;
	}
	
	public Product getProductById(int id) {
		Product product = null;
		Connection connection = manager.getConnection();
		String query = "select product.id_product, product.title tt_product, product.quantity, product.price, branch.title tt_branch\r\n"
				+ "from product\r\n"
				+ "join branch on product.id_branch = branch.id_branch\r\n"
				+ "where product.id_product = ?";
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (!rs.next()) {
				return null;
			} else {
				product = new Product(
						rs.getInt("id_product")
						, rs.getString("tt_product")
						, rs.getString("tt_branch")
						, rs.getInt("quantity")
						, rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, pst, connection);
		}
		return product;
	}
	
	public List<Branch> getBranchs() {
		List<Branch> branchs = new ArrayList<>();
		Connection connection = manager.getConnection();
		String query = "SELECT * FROM branch";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Branch branch = new Branch(rs.getInt("id_branch"), rs.getString("title"));
				branchs.add(branch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, st, connection);
		}
		return branchs;
	}
	
	public boolean updateProduct(int id, String title, int quantity, double price, String branch) {
		Connection connection = manager.getConnection();
		String query = "UPDATE product SET "
				+ "title=?, "
				+ "quantity=?, "
				+ "price=?, "
				+ "id_branch=(SELECT id_branch FROM branch WHERE title=?) "
				+ "WHERE id_product=?";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, title);
			pst.setInt(2, quantity);
			pst.setDouble(3, price);
			pst.setString(4, branch);
			pst.setInt(5, id);
			System.out.println(pst);
			int rsUpdate = pst.executeUpdate();
			System.out.println(rsUpdate);
			if (rsUpdate == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, pst, connection);
		}
		return true;
	}
	
	public boolean deleteById(int id) {
		Connection connection = manager.getConnection();
		String query = "delete from product where id_product = ?";
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int numberResolve = pst.executeUpdate();
			if (numberResolve == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(pst, connection);
		}
		return true;
	}
	
	
	public boolean insertProduct(String title, int quantity, double price, String branch) {
		Connection connection = manager.getConnection();
		String query = "insert into product(title, quantity, price, id_branch) \r\n"
				+ "values (?, ?, ?, (select id_branch from branch where title = ?))";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, title);
			pst.setInt(2, quantity);
			pst.setDouble(3, price);
			pst.setString(4, branch);
			int numberResolve = pst.executeUpdate();
			if (numberResolve == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean deleteBranchById(int id) {
		Connection connection = manager.getConnection();
		String query = "delete from branch where id_branch = ?";
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int numberResolve = pst.executeUpdate();
			if (numberResolve == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(pst, connection);
		}
		return true;
	}
	
	public boolean insertBranch(String title) {
		Connection connection = manager.getConnection();
		String query = "insert into branch(title) \r\n"
				+ "values (?)";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, title);
			int numberResolve = pst.executeUpdate();
			if (numberResolve == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(pst, connection);
		}
		return true;
	}
	
	public boolean updateBranch(int id, String branch) {
		Connection connection = manager.getConnection();
		String query = "update branch set title=? where id_branch=?";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, branch);
			pst.setInt(2, id);
			int numberResovle = pst.executeUpdate();
			if (numberResovle == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(pst, connection);
		}
		return true;
	}
	
	public Branch getBranchById(int id) {
		Connection connection = manager.getConnection();
		String query = "select * from branch where id_branch=?";
		Branch branch = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (!rs.next()) {
				return null;
			} 
			branch = new Branch(rs.getInt("id_branch"), rs.getString("title"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLUtil.close(rs, pst, connection);
		}
		return branch;
	}
	
	public Product getMaxPrice() {
		Product product = null;
		Connection connection = manager.getConnection();
		String query = "select * from product\r\n"
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
