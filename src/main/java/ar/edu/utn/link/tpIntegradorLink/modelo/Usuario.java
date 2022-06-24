package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String user;
	
	@JsonIgnore //Para que no salga la contrasenia en el json
	private String password;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private int numDoc;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Carrito carrito;
	
	@Column
	private boolean tieneMembresia;
	
	@Column
	private TipoUsuario tipo;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String user, String password, String nombre, String apellido, int numDoc,
			boolean tieneMembresia, TipoUsuario tipo) {
		super();
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numDoc = numDoc;
		this.carrito =  new Carrito();
		this.tieneMembresia = tieneMembresia;
		this.tipo = tipo;
	}

	public void pagar(double total, MedioPago medioPago) {
		// TODO Auto-generated method stub
	}

	public void agregarOrdenCompra(OrdenCompra ordenDeCompra) {
		// TODO Auto-generated method stub
	}

}
