package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.time.LocalDate;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrdenCompra {
	private String idFactura;
	private Collection<ProductoAComprar> productosAComprar;
	private LocalDate fechaDeCompra;
	private Collection<Promocion> promocionesAplicadas;
	private MedioPago medioPago;
	
	//
	public double montoFinalSinPromociones() {
		return productosAComprar.stream().mapToDouble(x->x.calcularPrecioProducto()).sum();
	}
	
	public double montoFinalConPromociones() {
		return this.montoFinalSinPromociones()-(promocionesAplicadas.stream().mapToDouble(x->x.aplicarA(this)).sum());
	}
}
