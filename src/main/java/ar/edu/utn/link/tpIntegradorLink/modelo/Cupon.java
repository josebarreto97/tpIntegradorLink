package ar.edu.utn.link.tpIntegradorLink.modelo;

public class Cupon implements Promocion {
	private Proveedor proveedor;
	private double descuento;
	
	@Override
	public double aplicarA(OrdenCompra ordenCompra) {
		return ordenCompra.getProductosAComprar().stream().filter(x->x.igualProveedor(proveedor)).mapToDouble(x->x.calcularPrecioProducto() * descuento).sum();
	}
	

}
