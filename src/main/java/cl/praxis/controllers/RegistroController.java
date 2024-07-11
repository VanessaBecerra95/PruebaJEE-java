package cl.praxis.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.models.dao.UserDAOImpl;
import cl.praxis.models.dto.User;

@WebServlet("/registro")
public class RegistroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistroController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String pesoStr = request.getParameter("peso");

        if (correo == null || correo.isEmpty() || password == null || password.isEmpty() || nick == null
                || nick.isEmpty() || nombre == null || nombre.isEmpty()) {
            response.sendRedirect("error.jsp");
            return;
        }
        
        int peso;
        try {
            peso = Integer.parseInt(pesoStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
            return;
        }

        UserDAOImpl uDAO = new UserDAOImpl();
        if (uDAO.isEmailRegistered(correo)) {
            request.setAttribute("error", "El correo electrónico ya existe");
            response.sendRedirect("error.jsp");
            return;
        }

        User user = new User();
        user.setCorreo(correo);
        user.setPassword(password);
        user.setNick(nick);
        user.setNombre(nombre);
        user.setPeso(peso);
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());

        try {
            uDAO.create(user);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}