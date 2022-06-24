package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@DiscriminatorValue("CUPON")
public class Cupon extends Promocion{
	@Column
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	//Constructores
	public Cupon() {
		super();
	}
	
	public Cupon(String nombre, Double porcentaje, boolean estaActivo, String codigo, Proveedor proveedor, Producto producto) {
		super(nombre, porcentaje, estaActivo);
		this.codigo = codigo;
		this.proveedor = proveedor;
		this.producto = producto;
	}
	
	//
	@Override
	public boolean esValidoPara(OrdenCompra ordenDeCompra) {
		Collection<ProductoEnCantidad> productos = ordenDeCompra.productosDeProovedor(this.proveedor);
		
		if(productos == null){
			return false;
		}
		
		return productos.stream().anyMatch(unProducto -> unProducto.getProducto().equals(this.producto));
	}

	@Override
	public Double totalADescontar(OrdenCompra ordenDeCompra) {		
		Collection<ProductoEnCantidad> productos = ordenDeCompra.productosDeProovedor(this.proveedor);

		double totalProductos = productos.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
		
		return totalProductos;
	}

	public boolean tieneProveedor(String proveedor2) {
		return this.getProveedor().tieneNombre(proveedor2);
	}
	
	@Override
	public boolean tieneCodigo(String codigo) {
		return this.codigo.equals(codigo);
	}
}
