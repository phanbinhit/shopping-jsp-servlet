package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SomethingController")
public class SomethingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher = null;

    public SomethingController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			response.sendRedirect("LoginController");
			return;
		} 
		dispatcher = request.getRequestDispatcher("views/something.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("email") == null) {
			response.sendRedirect("LoginController");
			return;
		} 
		Xuly xuly = new Xuly();
		String output = xuly.connect();
		request.setAttribute("output", output);
		dispatcher = request.getRequestDispatcher("views/something.jsp");
		dispatcher.forward(request, response);
	}

}
