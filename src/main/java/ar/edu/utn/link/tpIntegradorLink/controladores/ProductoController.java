package ar.edu.utn.link.tpIntegradorLink.controladores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.tpIntegradorLink.modelo.Carrito;
import ar.edu.utn.link.tpIntegradorLink.modelo.Producto;
import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoProducto;

@RepositoryRestController
public class ProductoController {
	
	@Autowired
	RepoProducto repoProductos;
	
	@RequestMapping(method = RequestMethod.GET, value = "/productos/habilitados")
	public @ResponseBody Page<Producto> productosHabilitados(Pageable page) {
		Page<Producto> productosHabilitados = repoProductos.findAllByHabilitado(true, page);
		
		return productosHabilitados;

	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/productos")
	public @ResponseBody String agregarProducto(@RequestBody Producto producto) {
		repoProductos.save(producto);
		
		return "Producto creado";	
	}
	
	/*
	@RequestMapping(method = RequestMethod.GET, value = "/productos/{nombre}")
	public Producto buscarProducto(@PathVariable("nombre") String nombre) {
		Producto buscarProducto = repoProductos.findByNombre(nombre);
		
		return buscarProducto;
	}*/
	
}
