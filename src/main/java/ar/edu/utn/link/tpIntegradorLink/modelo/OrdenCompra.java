package ar.edu.utn.link.tpIntegradorLink.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ar.edu.utn.link.tpIntegradorLink.excepciones.NoHayMedioPagoException;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class OrdenCompra {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private LocalDate fecha;
	
	@ManyToMany
	private Collection<Promocion> promociones;
	
	@OneToMany
	private Collection<ProductoEnCantidad> productoXCant;
	
	@ManyToOne
	private Usuario usuario;
	
	@Column
	private MedioPago medioPago;
	
	@Column
	private Double totalSinDescuento;
	
	@Column
	private Double totalADescontar;
	
	@Column
	private Double total;

	//Constructores
	public OrdenCompra() {
		super();
	}


	public OrdenCompra(LocalDate fecha, Collection<ProductoEnCantidad> productos,
			Usuario cliente, MedioPago medioPago) {
		super();
		this.fecha = fecha;
		this.productoXCant = productos;
		this.usuario = cliente;
		this.medioPago = medioPago;
		this.promociones = new ArrayList<Promocion>();
	}
	
	public OrdenCompra(LocalDate fecha, Collection<Promocion> promociones, Collection<ProductoEnCantidad> productoXCant,
			Usuario usuario, MedioPago medioPago, Double totalSinDescuento, Double totalADescontar, Double total) {
		super();
		this.fecha = fecha;
		this.promociones = promociones;
		this.productoXCant = productoXCant;
		this.usuario = usuario;
		this.medioPago = medioPago;
		this.totalSinDescuento = totalSinDescuento;
		this.totalADescontar = totalADescontar;
		this.total = total;
	}
	
	//
	public void ejecutar() throws Exception {
		usuario.pagar(this.total(), this.medioPago);
		usuario.agregarOrdenCompra(this);
	}
	
	public double total() throws Exception {
		
		//double totalProductos = totalSinDescuento();
		//double descuentosPromociones = totalADescontar();
		
		return  max(totalSinDescuento - totalADescontar, 0);
	}

	public double totalADescontar() throws Exception {
		if(this.medioPago == null) {
			throw new NoHayMedioPagoException("Se debe agregar un medio de pago a la orden de compra");
		}
		return promociones.stream().mapToDouble(promocion -> promocion.descuento(this)).sum();
	}

	public double totalSinDescuento() {
		return productoXCant.stream().mapToDouble(productoCant -> productoCant.precioFinal()).sum();
	}
	
	public  List<ProductoEnCantidad> productosDeProovedor(Proveedor proveedor) {
		 List<ProductoEnCantidad> productos = this.productoXCant.stream().filter(producto -> producto.getProducto().tieneProveedor(proveedor)).collect(Collectors.toList());
		 if(productos.isEmpty()) {
			 return null;
		 }
		 return productos;
	}
	
	public void agregarPromocion(Promocion promo) throws Exception{
		
			this.promociones.add(promo);
		
	}
	
	public void agregarPromociones(Collection<Promocion> promociones) {	
		Collection<Promocion> promocionesAplicables = promociones.stream().filter(promocion -> promocion.esValidoPara(this)).collect(Collectors.toList());
		
		this.promociones.addAll(promocionesAplicables);
	}

	private double max(double d, int i) {
		if(d > i) {
			return d;
		}
		return i;
	}

	public boolean clienteTieneMembresia() {
		return this.usuario.isTieneMembresia();
	}

	@Override
	public boolean equals(Object obj) {
		OrdenCompra otraOrden = (OrdenCompra) obj;
		
		return this.id.equals(otraOrden.getId());
	}
}
