package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BO.ProductBoImpl;
import model.BO.UserBo;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private RequestDispatcher dispatcher = null;
	private final ProductController productController;
	private final ProductBoImpl productBo;
	private final UserBo userBo;
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        productBo = new ProductBoImpl();
        userBo = new UserBo();
        productController = new ProductController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") != null) {
			response.sendRedirect("ProductController");
			return;
		}
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		if (userBo.checkLogin(email, password) != null) {
			request.getSession().setAttribute("email", email);
			response.sendRedirect("ProductController");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
