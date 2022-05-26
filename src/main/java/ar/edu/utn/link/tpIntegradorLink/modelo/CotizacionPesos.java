package ar.edu.utn.link.tpIntegradorLink.modelo;

public class CotizacionPesos implements Cotizacion{
	private double precio;
	
	@Override
	public double calcularPrecio() {
		return precio;
	}

}