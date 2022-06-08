package ar.edu.utn.link.tpIntegradorLink.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import ar.edu.utn.link.tpIntegradorLink.repo.RepoProducto;

@RepositoryRestController
public class ProductoController{
	@Autowired
	RepoProducto repoProducto;
}
