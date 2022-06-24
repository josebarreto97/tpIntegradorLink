package ar.edu.utn.link.tpIntegradorLink;

public class Login {

	public String usuario;
	public String password;
	public String getUsuario() {
		return usuario;
	}
	
	public Login() {
		super();
	}

	public Login(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
