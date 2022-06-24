package ar.edu.utn.link.tpIntegradorLink.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CuponAuxiliar {

	private String nombre;
	private boolean activo;
	private String codigo;
	private String nombreProveedor;
	private String nombreProducto;
	private Double porcentaje;
	
	//Constructores
	public CuponAuxiliar(){
		
	} 

	public CuponAuxiliar(String nombre, Double porcentaje, boolean estaActivo,String codigo, String nombreProveedor, String nombreProducto) {
		super();
		this.nombre = nombre;
		this.activo = estaActivo;
		this.codigo = codigo;
		this.nombreProveedor = nombreProveedor;
		this.nombreProducto = nombreProducto;
		this.porcentaje = porcentaje;
	}

}
