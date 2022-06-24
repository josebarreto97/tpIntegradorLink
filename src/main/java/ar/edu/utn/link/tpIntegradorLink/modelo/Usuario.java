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

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String user;
	
	@JsonIgnore
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




	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public TipoUsuario getTipo() {
		return tipo;
	}


	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getNumDoc() {
		return numDoc;
	}


	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}


	public Carrito getCarrito() {
		return carrito;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}


	public boolean isTieneMembresia() {
		return tieneMembresia;
	}


	public void setTieneMembresia(boolean tieneMembresia) {
		this.tieneMembresia = tieneMembresia;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public void pagar(double total, MedioPago medioPago) {
		// TODO Auto-generated method stub
		
	}




	public void agregarOrdenCompra(OrdenCompra ordenDeCompra) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
