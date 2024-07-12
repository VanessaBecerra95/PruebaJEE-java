package cl.praxis.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.models.db.Db;
import cl.praxis.models.dto.RolesUsuarios;

public class RolesUsuariosDAOImpl implements RolesUsuariosDAO {

	public RolesUsuariosDAOImpl(Connection c) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(RolesUsuarios direccion) {
		// TODO Auto-generated method stub

	}

	@Override
	public RolesUsuarios read(int id) {
		return null;
	}

	@Override
	public List<RolesUsuarios> readAll() {
		return null;
	}

	@Override
	public void update(RolesUsuarios direccion) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public List<RolesUsuarios> readAllByUsuarioID(int usuarioID) {
	    List<RolesUsuarios> rolesUsuarios = new ArrayList<>();
	    try (Connection c = Db.getConnect();
	            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM roles_usuarios WHERE usuario_id =?")) {
	        pstmt.setInt(1, usuarioID);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                RolesUsuarios role = new RolesUsuarios(rs.getInt("usuario_id"), rs.getInt("rol_id"));
	                rolesUsuarios.add(role);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR en metodo readAllByUsuarioID()");
	        e.printStackTrace();
	    }
	    return rolesUsuarios;
	}

}
