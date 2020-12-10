package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Product;
import model.BO.ProductBoImpl;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private RequestDispatcher dispatcher = null;
	private final ProductBoImpl productBo;
	private static final long serialVersionUID = 1L;

    public ProductController() {
    	productBo = new ProductBoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			response.sendRedirect("LoginController");
			return;
		} 
		List<Product> products = productBo.getProducts();
		request.setAttribute("products", products);
		dispatcher = request.getRequestDispatcher("/views/product.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
