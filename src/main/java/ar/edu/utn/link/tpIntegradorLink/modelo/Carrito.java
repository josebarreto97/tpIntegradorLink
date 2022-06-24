package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<ProductoEnCantidad> productosXCant;
	
	//Constructores
	public Carrito() {
		super();
		this.productosXCant = new ArrayList<ProductoEnCantidad>();
		
	}
	
	public Carrito(Collection<ProductoEnCantidad> productosXCant) {
		super();
		this.productosXCant = productosXCant;
	}
	
	//
	public void agregarProducto(ProductoEnCantidad producto) {
		this.productosXCant.add(producto);
	}
	
	public void eliminarProducto(ProductoEnCantidad producto){
		this.productosXCant.remove(producto);
	}

	public Double total() {
		return productosXCant.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
	}
	
	public void vaciar() {
		this.productosXCant = new ArrayList<ProductoEnCantidad>();
	}


	public Collection<ProductoEnCantidad> getProductos() {
		return productosXCant;
	}

	public void setProductos(Collection<ProductoEnCantidad> productos) {
		this.productosXCant = productos;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Collection<ProductoEnCantidad> getProductosXCant() {
		return productosXCant;
	}



	public void setProductosXCant(Collection<ProductoEnCantidad> productosXCant) {
		this.productosXCant = productosXCant;
	}
	
	
	
}
