package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ProductoEnCantidad {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Producto producto;
	
	@Column
	private int cant;
	
	//Constructores
	public ProductoEnCantidad() {
		super();
	}

	public ProductoEnCantidad(Producto producto, int cant) {
		super();
		this.producto = producto;
		this.cant = cant;
	}
	
	//
	public double precioFinal(){
		return producto.getPrecioDolar()*cant;
	}
}
