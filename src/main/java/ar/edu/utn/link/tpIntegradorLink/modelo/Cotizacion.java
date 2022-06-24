package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cotizacion {

	private String fecha;
	private Double compra;
	private Double venta;
	
	//Constructores
	public Cotizacion(String fecha, Double compra, Double venta) {
		super();
		this.fecha = fecha;
		this.compra = compra;
		this.venta = venta;
	}
	public Cotizacion() {
		super();
	}
	
	
	
}
