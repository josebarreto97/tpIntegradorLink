package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@DiscriminatorValue("MEDIOPAGO")
public class PromoMedioPago extends Promocion{

	@Enumerated(EnumType.STRING)
	private MedioPago medioPago;

	public PromoMedioPago() {
		super();
	}

	public PromoMedioPago(String nombre, Double porcentaje, boolean estaActivo, MedioPago medioPago) {
		super(nombre, porcentaje, estaActivo);
		this.medioPago = medioPago;
	}

	@Override
	public boolean esValidoPara(OrdenCompra ordenDeCompra) {		
		return ordenDeCompra.totalSinDescuento() > medioPago.minimoPermitido();
	}

}
