package model.BO;

import java.util.List;

import entities.Branch;
import entities.Product;
import model.DAO.ProductDaoImpl;

public class ProductBoImpl{
	
	private final ProductDaoImpl productDao;
	
	public ProductBoImpl() {
		productDao = new ProductDaoImpl();
	}

	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	public List<Branch> getBranchs() {
		return productDao.getBranchs();
	}
	
	public boolean updateProduct(int id, String title, int quantity, double price, String branch) {
		return productDao.updateProduct(id, title, quantity, price, branch);
	}
	
	public boolean deleteById(int id) {
		return productDao.deleteById(id);
	}
	
	public boolean insertProduct(String title, int quantity, double price, String branch) {
		return productDao.insertProduct(title, quantity, price, branch);
	}
	
	public boolean deleteBranchById(int id) {
		return productDao.deleteBranchById(id);
	}
	
	public boolean insertBranch(String title) {
		return productDao.insertBranch(title);
	}
	
	public boolean updateBranch(int id, String branch) {
		return productDao.updateBranch(id, branch);
	}
	
	public Branch getBranchById(int id) {
		return productDao.getBranchById(id);
	}
	
	public Product getMaxPrice() {
		return productDao.getMaxPrice();
	}
}
