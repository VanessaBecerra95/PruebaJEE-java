package cl.praxis.models.dto;

public class Direcciones {
	private int id;
	private String nombre;
	private String numeracion;
	private int usuarioID;
	
	
	public Direcciones() {
		super();
	}


	public Direcciones(int id, String nombre, String numeracion, int usuarioID) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeracion = numeracion;
		this.usuarioID = usuarioID;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNumeracion() {
		return numeracion;
	}


	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}


	public int getUsuarioID() {
		return usuarioID;
	}


	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}


	@Override
	public String toString() {
		return "Direcciones [id=" + id + ", nombre=" + nombre + ", numeracion=" + numeracion + ", usuarioID="
				+ usuarioID + "]";
	}
	
	
	
}
