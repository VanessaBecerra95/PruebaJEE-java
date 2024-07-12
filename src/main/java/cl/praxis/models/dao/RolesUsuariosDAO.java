package cl.praxis.models.dao;

import java.util.List;

import cl.praxis.models.dto.RolesUsuarios;

public interface RolesUsuariosDAO {
	void create(RolesUsuarios direccion);
	RolesUsuarios read(int id);
	List<RolesUsuarios> readAll();
	void update(RolesUsuarios direccion);
	void delete(int id);
	public List<RolesUsuarios> readAllByUsuarioID(int usuarioID);
}
