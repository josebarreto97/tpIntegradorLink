package ar.edu.utn.link.tpIntegradorLink.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class ConvertidorDolar {
	String fecha;
	String compra;
	String venta;
	String url;
	
	//Constructores
	public ConvertidorDolar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConvertidorDolar(String url) {
		super();
		this.url = url;
	}
	
	//
	public abstract Double convertirAPesos(Double dolares);
	public abstract Double convertirADolares(Double pesos);
}
