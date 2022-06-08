package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idProducto;
	
	private String nombre;
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
