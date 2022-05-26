package ar.edu.utn.link.tpIntegradorLink.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoAComprar {
	private Producto producto;
	private int cantidad;
	private double precio;
	
	//
	public double calcularPrecioProducto() {
		return this.cantidad * this.precio;
	}
	
	public boolean igualProveedor(Proveedor proveedor) {
		return this.getProducto().getProveedor().equals(proveedor);
	}
	

}
