package cl.praxis.models.service;

import cl.praxis.models.dao.UserDAO;
import cl.praxis.models.dao.UserDAOImpl;
import cl.praxis.models.dto.User;

public class UserService {
	
private UserDAO userDAO = new UserDAOImpl();
	
	public void create (User u) {
		userDAO.create(u);
	}
	
	public User validateLogin(String correo, String password) {
	    return userDAO.validateLogin(correo, password);
	}
	
	public boolean isEmailRegistered(String email) {
		return userDAO.isEmailRegistered(email);
	}
	
}
