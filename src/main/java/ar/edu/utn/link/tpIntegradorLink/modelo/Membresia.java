package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MEMBRESIA")
public class Membresia extends Promocion{
	
	//Constructores
	public Membresia() {
		super();
	}

	public Membresia(String nombre, Double porcentaje, boolean estaActivo) {
		super(nombre, porcentaje, estaActivo);
	}

	@Override
	public boolean esValidoPara(OrdenCompra ordenDeCompra) {
		return ordenDeCompra.clienteTieneMembresia();	
	}
	
}
