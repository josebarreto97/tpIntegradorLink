package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "TIPO")
public class Promocion {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private Double porcentaje;
	
	@Column
	private boolean estaActivo;
	
	//Constructores
	public Promocion() {
		super();
	}

	public Promocion(String nombre, Double porcentaje, boolean estaActivo) {
		super();
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.estaActivo = estaActivo;
	}
	
	//
	public double descuento(OrdenCompra orden) {
		if(!this.esValidoPara(orden)) {		
			return 0;
		}
		double totalADescontar = this.totalADescontar(orden);
		return totalADescontar*(porcentaje/100);
	}

	public Double totalADescontar(OrdenCompra orden) {
		return orden.totalSinDescuento();
	}

	public boolean esValidoPara(OrdenCompra ordenDeCompra) {
		return true;
	}

	public boolean tieneNombre(String nombre2) {
		return this.nombre.equals(nombre2);
	}

	@Override
	public boolean equals(Object obj) {
		
		Promocion promo = (Promocion) obj;
		
		return this.tieneNombre(promo.getNombre());
	}

	public boolean tieneCodigo(String codigo) {
		return false;
	}

}
