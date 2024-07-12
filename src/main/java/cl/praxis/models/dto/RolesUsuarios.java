package cl.praxis.models.dto;

public class RolesUsuarios {
	private int usuarioID;
	private int rolID;
	
	public RolesUsuarios() {
		super();
	}

	public RolesUsuarios(int usuarioID, int rolID) {
		super();
		this.usuarioID = usuarioID;
		this.rolID = rolID;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public int getRolID() {
		return rolID;
	}

	public void setRolID(int rolID) {
		this.rolID = rolID;
	}

	@Override
	public String toString() {
		return "RolesUsuarios [usuarioID=" + usuarioID + ", rolID=" + rolID + "]";
	}
	
}
