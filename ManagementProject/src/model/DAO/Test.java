package model.DAO;

import java.util.List;

import controller.ProductController;
import entities.Product;
import model.BO.ProductBoImpl;

public class Test {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		ProductDaoImpl bo = new ProductDaoImpl();
		System.out.println(bo.getProductById(3));
	}
}
