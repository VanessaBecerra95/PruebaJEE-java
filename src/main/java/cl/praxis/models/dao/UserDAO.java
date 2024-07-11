package cl.praxis.models.dao;

import java.util.List;

import cl.praxis.models.dto.User;

public interface UserDAO {
	void create(User u);
	User read(int id);
	List<User> read();
	void update(User u);
	void delete(int id);
	User validateLogin(String correo, String password);
	boolean isEmailRegistered(String email);
}
