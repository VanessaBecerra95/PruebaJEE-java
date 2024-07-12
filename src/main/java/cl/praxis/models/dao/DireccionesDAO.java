package cl.praxis.models.dao;

import java.util.List;

import cl.praxis.models.dto.Direcciones;

public interface DireccionesDAO {
	void create(Direcciones direccion);
	Direcciones read(int id);
	List<Direcciones> readAll();
	void update(Direcciones direccion);
	void delete(int id);
}
