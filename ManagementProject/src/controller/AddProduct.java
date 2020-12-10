package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Branch;
import model.BO.ProductBoImpl;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductBoImpl productBo;
    private RequestDispatcher dispatcher = null;
    public AddProduct() {
        productBo = new ProductBoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			System.out.println(request.getSession().getAttribute("email"));
			response.sendRedirect("LoginController");
			return;
		} 
		List<Branch> branchs = productBo.getBranchs();
		request.setAttribute("branchs", branchs);
		dispatcher = request.getRequestDispatcher("/views/add.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String branch = request.getParameter("branch");
		productBo.insertProduct(title, Integer.parseInt(quantity),Double.parseDouble(price), branch);
		response.sendRedirect("ProductController");
	}

}
