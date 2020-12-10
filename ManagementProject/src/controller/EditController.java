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
import entities.Product;
import model.BO.ProductBoImpl;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final ProductBoImpl productBo;
    private RequestDispatcher dispatcher = null;
    private String id = "";

    public EditController() {
        productBo = new ProductBoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			System.out.println(request.getSession().getAttribute("email"));
			response.sendRedirect("LoginController");
			return;
		} 
		id = request.getParameter("id");
		int idProduct = 0;
		try {
			idProduct = Integer.parseInt(id);
			Product product = productBo.getProductById(idProduct); 
			List<Branch> branchs = productBo.getBranchs();
			request.setAttribute("product", product);
			request.setAttribute("branchs", branchs);
			request.setAttribute("validId", true);
			dispatcher = request.getRequestDispatcher("/views/edit.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("validId", false);
			dispatcher = request.getRequestDispatcher("/views/edit.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String branch = request.getParameter("branch");
		if (productBo.updateProduct(Integer.parseInt(id), title, Integer.parseInt(quantity), Double.parseDouble(price), branch)) {
			response.sendRedirect("ProductController");
		} else {
			response.sendRedirect("EditController?id="+ id +"");
		}
	}

}
