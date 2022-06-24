package ar.edu.utn.link.tpIntegradorLink.modelo;

public enum MedioPago {
	DEBITO,
	CREDITO;

	public Tarjeta obtenerTarjeta(Usuario cliente) {
		return null;
	}

	public double minimoPermitido() {
		return 0;
	}
	
	public MedioPago medioCorrespondiente(Integer num) {
		switch(num) {
			case 1:
				return MedioPago.DEBITO;
			case 2:
				return MedioPago.CREDITO;
		}	
		return null;
	}
}
