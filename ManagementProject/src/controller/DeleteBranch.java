package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.ProductBoImpl;

@WebServlet("/DeleteBranch")
public class DeleteBranch extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final ProductBoImpl productBo;
    private RequestDispatcher dispatcher = null;
       
    public DeleteBranch() {
    	productBo = new ProductBoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			System.out.println(request.getSession().getAttribute("email"));
			response.sendRedirect("LoginController");
			return;
		} 
		String id = request.getParameter("id");
		int idBranch = Integer.parseInt(id);
		if (productBo.deleteBranchById(idBranch)) {
			response.sendRedirect("BranchController");
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
