package cl.praxis.models.dto;
import java.time.LocalDate;

public class User {
	private int id;
	private String correo;
	private LocalDate createdAt;
	private String nick;
	private String nombre;
	private String password;
	private int peso;
	private LocalDate updatedAt;
	
	public User() {
		super();

	}

	public User(int id, String correo, LocalDate createdAt, String nick, String nombre, String password, int peso,
			LocalDate updatedAt) {
		super();
		this.id = id;
		this.correo = correo;
		this.createdAt = createdAt;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", correo=" + correo + ", createdAt=" + createdAt + ", nick=" + nick + ", nombre="
				+ nombre + ", password=" + password + ", peso=" + peso + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
