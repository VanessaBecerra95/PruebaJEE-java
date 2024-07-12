package cl.praxis.models.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.models.db.Db;
import cl.praxis.models.dto.Direcciones;

public class DireccionesDAOImpl implements DireccionesDAO {

	@Override
	public void create(Direcciones direccion) {
	}

	@Override
	public Direcciones read(int id) {
		Direcciones d = null;

	    try {
	        Connection c = Db.getConnect();
	        Statement s = c.createStatement();
	        String sql = "select id, nombre, numeracion, usuario_id from direcciones where id = " + id;

	        ResultSet rs = s.executeQuery(sql);
	        if (rs.next()) {
	            d = new Direcciones(rs.getInt("id"), rs.getString("nombre"), rs.getString("numeracion"), rs.getInt("usuario_id"));
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR en método read(id)");
	        e.printStackTrace();
	    }

	    return d;
	}

	@Override
	public List<Direcciones> readAll() {
	    List<Direcciones> direcciones = new ArrayList<>();

	    try {
	        Connection c = Db.getConnect();
	        Statement s = c.createStatement();
	        String sql = "select id, nombre, numeracion, usuario_id from direcciones";

	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) {
	            Direcciones d = new Direcciones(rs.getInt("id"), rs.getString("nombre"), rs.getString("numeracion"), rs.getInt("usuario_id"));
	            direcciones.add(d);
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR en método readAll()");
	        e.printStackTrace();
	    }

	    return direcciones;
	}

	@Override
	public void update(Direcciones direccion) {
		
	}

	@Override
	public void delete(int id) {

	}

}
