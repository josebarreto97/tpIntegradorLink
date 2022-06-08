package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String username;
	private String password;
	@OneToOne
	private TipoUsuario tipoUsuario;
}
