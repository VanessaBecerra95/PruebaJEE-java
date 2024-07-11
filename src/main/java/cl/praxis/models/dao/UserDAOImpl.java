package cl.praxis.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

import cl.praxis.models.db.Db;
import cl.praxis.models.dto.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void create(User u) {
		if (isEmailRegistered(u.getCorreo())) {
			throw new RuntimeException("El correo electrónico ya existe");
		}

		String sql = "INSERT INTO usuarios (correo, created_at, nick, nombre, password, peso, updated_at) VALUES ('"
				+ u.getCorreo() + "', '" + u.getCreatedAt() + "', '" + u.getNick() + "', '" + u.getNombre() + "', '"
				+ u.getPassword() + "', " + u.getPeso() + ", '" + u.getUpdatedAt() + "')";

		try {
			Connection c = Db.getConnect();
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			System.out.println("ERROR en método create()");
			e.printStackTrace();
		}
	}

	@Override
	public User read(int id) {
		User u = null;

		try {
			Connection c = Db.getConnect();
			Statement s = c.createStatement();
			String sql = "select id, correo, created_at, nick, nombre, password, peso, updated_at from usuarios where id = "
					+ id;

			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				Timestamp tm1 = rs.getTimestamp("created_at");
				Timestamp tm2 = rs.getTimestamp("updated_at");
				u = new User(rs.getInt("id"), rs.getString("correo"), tm1.toLocalDateTime().toLocalDate(),
						rs.getString("nick"), rs.getString("nombre"), rs.getString("password"), rs.getInt("peso"),
						tm2.toLocalDateTime().toLocalDate());
			}
		} catch (SQLException e) {
			System.out.println("ERROR en método read(id)");
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public List<User> read() {
		List<User> user = new ArrayList<User>();
		try {

			Connection c = Db.getConnect();

			Statement stm = c.createStatement();

			ResultSet rs = stm.executeQuery(
					"select id, correo, created_at, nick, nombre, password, peso, update_at from usuarios");

			while (rs.next()) {

				Timestamp tm1 = rs.getTimestamp("created_at");
				Timestamp tm2 = rs.getTimestamp("updated_at");

				user.add(new User(rs.getInt("id"), rs.getString("correo"), tm1.toLocalDateTime().toLocalDate(),
						rs.getString("nick"), rs.getString("nombre"), rs.getString("password"), rs.getInt("peso"),
						tm2.toLocalDateTime().toLocalDate()));
			}

		} catch (SQLException e) {
			System.out.println("ERROR en metodo READ()");
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void update(User u) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public User validateLogin(String correo, String password) {
		User user = new User();
		try (Connection c = Db.getConnect();
				PreparedStatement pstmt = c
						.prepareStatement("SELECT * FROM usuarios WHERE correo =? AND password =?")) {
			pstmt.setString(1, correo);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user.setCorreo(rs.getString("correo"));
					user.setNombre(rs.getString("nombre"));
					return user;
				}
			}

		} catch (SQLException e) {
			System.out.println("ERROR en metodo validateLogin()");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean isEmailRegistered(String email) {
	    boolean isRegistered = false;

	    try (Connection c = Db.getConnect();
	         PreparedStatement pstmt = c.prepareStatement("SELECT 1 FROM usuarios WHERE correo = ?")) {
	        pstmt.setString(1, email);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                isRegistered = true;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al verificar correo electrónico: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return isRegistered;
	}

}
