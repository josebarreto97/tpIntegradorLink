package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Membresia implements Promocion{
	private Collection<Cliente> clientesMiembros;
	private double descuento;
	private Cliente clienteComprador;
	
	@Override
	public double aplicarA(OrdenCompra ordenCompra) {
		if(clientesMiembros.contains(clienteComprador)) {
			return ordenCompra.montoFinalSinPromociones() * descuento;
		}else {
			return 1;
		}
		
	}

}
