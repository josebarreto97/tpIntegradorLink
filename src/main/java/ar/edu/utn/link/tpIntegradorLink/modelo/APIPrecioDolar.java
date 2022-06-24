package ar.edu.utn.link.tpIntegradorLink.modelo;

import org.springframework.web.client.RestTemplate;

public class APIPrecioDolar extends ConvertidorDolar{

	public APIPrecioDolar(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}

	public APIPrecioDolar() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double convertirAPesos(Double dolares) {
		
		Cotizacion cotizacionOficial = this.cotizacionOficial();
		return dolares*cotizacionOficial.getCompra();
		//return dolares*precio1dolar;
	}

	@Override
	public Double convertirADolares(Double pesos) {
		Cotizacion cotizacionOficial = this.cotizacionOficial();
		return pesos/cotizacionOficial.getVenta();
		//return pesos/precio1dolar;
	}
	
	public Cotizacion cotizacionOficial() {	
		RestTemplate restTemplate = new RestTemplate();
		Cotizacion cotizacion = restTemplate.getForObject(this.getUrl(), Cotizacion.class);
		
		//System.out.println("Compra: " + String.valueOf(cotizacion.getCompra()));
		//System.out.println("Venta: " + String.valueOf(cotizacion.getVenta()));

		return cotizacion;
	}
}
