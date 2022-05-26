package ar.edu.utn.link.tpIntegradorLink.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Producto {
	private String idProducto;
	private String descripcion;
	private double precio;
	private boolean estaDisponible;
	private int stock;
	private Cotizacion cotizacion;
	private Proveedor proveedor;
	
	//
	public void restarStock(int cantidad) {
		if(stock<=cantidad) {
			estaDisponible=false;
		}else {
			stock-=cantidad;
		}
	}

}
