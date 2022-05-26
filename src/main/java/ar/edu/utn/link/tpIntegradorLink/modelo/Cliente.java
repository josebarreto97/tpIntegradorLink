package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.time.LocalDate;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
	private String apellido;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String nroDocumento;
	private String telefono;
	private String mail;
	private Collection<OrdenCompra> comprasEfectuadas;
	
	//metodos
	private void hacerCompra(OrdenCompra ordenCompra) {
		comprasEfectuadas.add(ordenCompra);
	}
}
