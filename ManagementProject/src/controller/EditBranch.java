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

@WebServlet("/EditBranch")
public class EditBranch extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final ProductBoImpl productBo;
    private RequestDispatcher dispatcher = null;
    private String id = "";
    private int idBranch;

    public EditBranch() {
    	productBo = new ProductBoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			System.out.println(request.getSession().getAttribute("email"));
			response.sendRedirect("LoginController");
			return;
		} 
		id = request.getParameter("id");
		try {
			idBranch = Integer.parseInt(id);
			List<Branch> branchs = productBo.getBranchs();
			Branch branch = productBo.getBranchById(idBranch);
			request.setAttribute("branch", branch);
			request.setAttribute("branchs", branchs);
			request.setAttribute("validId", true);
			dispatcher = request.getRequestDispatcher("/views/edit-branch.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("validId", false);
			dispatcher = request.getRequestDispatcher("/views/edit-branch.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch = request.getParameter("branch");
		if (productBo.updateBranch(idBranch, branch)) {
			response.sendRedirect("BranchController");
		} else {
			response.sendRedirect("EditBranch?id="+ id +"");
		}
	}

}
