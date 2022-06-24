package ar.edu.utn.link.tpIntegradorLink.controladores;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.tpIntegradorLink.modelo.Carrito;
import ar.edu.utn.link.tpIntegradorLink.modelo.OrdenCompra;
import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoOrdenesCompra;

@RepositoryRestController
public class OrdenesCompraController {

	@Autowired
	RepoOrdenesCompra repoOrdenes;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/ordenesDeCompra")
	public @ResponseBody ResponseEntity<OrdenCompra> agregarOrden(@RequestBody EntityModel<OrdenCompra> orden) {
		
		try {
			repoOrdenes.save(orden.getContent());
			
		}catch (Exception e) {
			return null;
		}
		
		Usuario usuario = orden.getContent().getUsuario();
		Carrito carrito = usuario.getCarrito();
		carrito.vaciar();
		
		return ResponseEntity.ok(orden.getContent());
		
	}
	
}
