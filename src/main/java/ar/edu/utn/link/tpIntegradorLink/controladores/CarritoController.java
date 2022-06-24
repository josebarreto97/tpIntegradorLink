package ar.edu.utn.link.tpIntegradorLink.controladores;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.tpIntegradorLink.modelo.Carrito;
import ar.edu.utn.link.tpIntegradorLink.modelo.MedioPago;
import ar.edu.utn.link.tpIntegradorLink.modelo.OrdenCompra;
import ar.edu.utn.link.tpIntegradorLink.modelo.ProductoEnCantidad;
import ar.edu.utn.link.tpIntegradorLink.modelo.Promocion;
import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoCarrito;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoProductoEnCantidad;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoPromocion;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoUsuario;

@RepositoryRestController
public class CarritoController {

	@Autowired
	RepoCarrito repoCarritos;
	
	@Autowired
	RepoProductoEnCantidad repoProductosXCant;
	
	@Autowired
	RepoUsuario repoUsuarios ;
	
	@Autowired
	RepoPromocion repoPromociones;
	
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/carritos/{carritoId}/agregarProducto")
	public @ResponseBody ResponseEntity<ProductoEnCantidad> agregarProducto(@PathVariable("carritoId") Integer carritoId , @RequestBody EntityModel<ProductoEnCantidad>  productoXCant) {
		
		
		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		try {
			carrito.agregarProducto(productoXCant.getContent());
		}catch (Exception e) {
			return null;
		}
		
		return ResponseEntity.ok(productoXCant.getContent());
		
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/carritos/{carritoId}/eliminarProducto")
	public @ResponseBody String eliminarProducto(@PathVariable("carritoId") Integer carritoId , @RequestBody Integer idProductoXCant) {
		
	
		Optional<ProductoEnCantidad> optionalProductoXCant = repoProductosXCant.findById(idProductoXCant);

		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		ProductoEnCantidad productoXCant = optionalProductoXCant.get();
		
		try {
			carrito.eliminarProducto(productoXCant);
			repoProductosXCant.delete(productoXCant);
		}catch (Exception e) {
			return "No se pudo eliminar el producto del carrito";
		}
		
		
		
		return "Se pudo eliminar el producto del carrito";
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/carritos/{carritoId}/productosXCant")
	public @ResponseBody List<ProductoEnCantidad> mostrarProductosXCant(@PathVariable("carritoId") Integer carritoId) {
		

		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		

		
		return (List<ProductoEnCantidad>) carrito.getProductosXCant();
		
	}
	
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/carritos/{carritoId}/generarOrdenDeCompra")
	public @ResponseBody OrdenCompra generarOrdenDeCompra(@PathVariable("carritoId") Integer carritoId, @RequestBody Integer numMedioPago) throws Exception{
		
		System.out.println(numMedioPago);
		
		Optional<Carrito> optionalCarrito = repoCarritos.findById(carritoId);
		
		if(!optionalCarrito.isPresent()) {
			return null;
		}
		
		Carrito carrito = optionalCarrito.get();
		
		Usuario usuario = repoUsuarios.findByCarrito(carrito);
		
		Collection<Promocion> promocionesActivas = repoPromociones.findAllByEstaActivo(true);
		
		
		MedioPago medio = this.medioCorrespondiente(numMedioPago);
		
		
		OrdenCompra ordenDeCompra = new OrdenCompra(LocalDate.now(), carrito.getProductos(), usuario, medio);
		
		ordenDeCompra.agregarPromociones(promocionesActivas);
		ordenDeCompra.setTotalSinDescuento(ordenDeCompra.totalSinDescuento());
		ordenDeCompra.setTotalADescontar(ordenDeCompra.totalADescontar());
		ordenDeCompra.setTotal(ordenDeCompra.total());

		
		return ordenDeCompra;
		
		
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
