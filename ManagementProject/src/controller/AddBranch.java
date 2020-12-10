package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.ProductBoImpl;

@WebServlet("/AddBranch")
public class AddBranch extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final ProductBoImpl productBo;
    private RequestDispatcher dispatcher = null;
    
    public AddBranch() {
        productBo = new ProductBoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			System.out.println(request.getSession().getAttribute("email"));
			response.sendRedirect("LoginController");
			return;
		} 
		dispatcher = request.getRequestDispatcher("/views/add-branch.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		productBo.insertBranch(title);
		response.sendRedirect("BranchController");
	}

}
