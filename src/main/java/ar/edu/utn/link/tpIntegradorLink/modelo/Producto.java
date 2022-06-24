package ar.edu.utn.link.tpIntegradorLink.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private Double precioDolar;

	@ManyToOne
	private Proveedor proveedor;
	
	@Column(length = 1000)
	private String urlImagen;
	
	@Column
	private boolean habilitado;
	
	//Constructor
	public Producto() {
		super();
	}

	public Producto(String nombre, String descripcion, Double precioDolar, Proveedor proveedor, String urlImagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioDolar = precioDolar;
		this.proveedor = proveedor;
		this.urlImagen = urlImagen;
		this.habilitado = true;
		//Lo hare desde el front con Angular
		//this.convertidor = new ApiConvertidor("http://api-dolar-argentina.herokuapp.com/api/dolaroficial");
	}
	
	//LOGICA IMPLEMENTADA PARA CONSUMIR API DOLAR... Iba a utilizarla en el Frontend
	@Value("${tp.apiPrecioDolar}")
	String apiPrecioDolar; // uri
	
	private Float precioDolarActual() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://api-dolar-argentina.herokuapp.com/api/dolaroficial/";
		ConvertidorDolar result = restTemplate.getForObject(uri, ConvertidorDolar.class);
		return Float.parseFloat(result.getCompra());
	}
	
	public double getPrecioPesos() {
		return 0;
		//return convertidor.convertirAPesos(this.precioDolar);
	}
	
	@Override
	public boolean equals(Object obj) {
		Producto otroProducto = (Producto) obj;
		
		return this.tieneNombre(otroProducto.getNombre()) && this.tieneProveedor(otroProducto.getProveedor());
	}
	
	public boolean tieneProveedor(Proveedor proveedor2) {
		return this.proveedor.equals(proveedor2);
	}

	public boolean tieneNombre(String nombre2) {	
		return this.getNombre().equals(nombre2);
	}
}