package ar.edu.utn.link.tpIntegradorLink.modelo;

import ar.edu.utn.link.tpIntegradorLink.excepciones.TarjetaSinSaldoException;

public class Tarjeta {
	private String numeroTarjeta;
	private Double saldo;

	public void pagar(double total) throws TarjetaSinSaldoException {
		if(this.saldo < total) {
			throw new TarjetaSinSaldoException("La tarjeta " + this.numeroTarjeta + " no tiene suficiente saldo para pagar " + String.valueOf(total));
		}else {
			saldo -= total;
		}
	}

}
