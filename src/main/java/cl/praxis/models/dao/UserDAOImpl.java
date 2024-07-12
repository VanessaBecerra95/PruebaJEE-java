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
import cl.praxis.models.dto.Direcciones;
import cl.praxis.models.dto.RolesUsuarios;
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
	    User user = null;
	    try (Connection c = Db.getConnect();
	            PreparedStatement pstmt = c
	                   .prepareStatement("SELECT * FROM usuarios WHERE correo =? AND password =?")) {
	        pstmt.setString(1, correo);
	        pstmt.setString(2, password);
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setCorreo(rs.getString("correo"));
	                user.setNombre(rs.getString("nombre"));
	                user.setNick(rs.getString("nick"));
	                user.setPassword(rs.getString("password"));
	                user.setPeso(rs.getInt("peso"));
	                user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime().toLocalDate());
	                user.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime().toLocalDate());

	                RolesUsuariosDAO rolesDAO = new RolesUsuariosDAOImpl(c);
	                List<RolesUsuarios> roles = rolesDAO.readAllByUsuarioID(rs.getInt("id"));
	                user.setRoles(roles);

	                
	                boolean hasRoleId1 = false;
	                for (RolesUsuarios role : roles) {
	                    if (role.getRolID() == 1) {
	                        hasRoleId1 = true;
	                        break;
	                    }
	                }

	                if (hasRoleId1) {
	                    return user;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al verificar correo electrónico: " + e.getMessage());
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
	
	@Override
	public List<User> readAllWithDirecciones() {
	    List<User> users = new ArrayList<>();

	    try {
	        Connection c = Db.getConnect();
	        Statement s = c.createStatement();
	        String sql = "select u.id, u.correo, u.created_at, u.nick, u.nombre, u.password, u.peso, u.updated_at, d.id, d.nombre, d.numeracion, d.usuario_id " +
	                     "from usuarios u " +
	                     "left join direcciones d on u.id = d.usuario_id";

	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) {
	            Timestamp tm1 = rs.getTimestamp("created_at");
	            Timestamp tm2 = rs.getTimestamp("updated_at");
	            User u = new User(rs.getInt("id"), rs.getString("correo"), tm1.toLocalDateTime().toLocalDate(),
	                    rs.getString("nick"), rs.getString("nombre"), rs.getString("password"), rs.getInt("peso"),
	                    tm2.toLocalDateTime().toLocalDate());
	            Direcciones d = new Direcciones();
	            d.setId(rs.getInt("id"));
	            d.setNombre(rs.getString("nombre"));
	            d.setNumeracion(rs.getString("numeracion"));
	            d.setUsuarioID(rs.getInt("usuario_id"));
	            u.setDireccion(d);
	            users.add(u);
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR en método readAllWithDirecciones()");
	        e.printStackTrace();
	    }

	    return users;
	}

}
