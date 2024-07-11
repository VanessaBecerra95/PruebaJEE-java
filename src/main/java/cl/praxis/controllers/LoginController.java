package cl.praxis.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.praxis.models.dao.UserDAO;
import cl.praxis.models.dao.UserDAOImpl;
import cl.praxis.models.dto.User;
import cl.praxis.models.db.Db;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public LoginController() {
		super();
		userDAO = new UserDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");

		try (Connection connection = Db.getConnect()) {
			User usuario = userDAO.validateLogin(correo, password);

			if (usuario != null) {
				HttpSession session = request.getSession();
				System.out.println("Almacenando usuario en sesión: " + usuario);
				session.setAttribute("usuario", usuario);
				response.sendRedirect("home.jsp");
			} else {
				request.setAttribute("error", "Correo o contraseña incorrectos");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			throw new ServletException("Error al autenticar el usuario", e);
		}
	}
}
