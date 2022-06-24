package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Proveedor;

@RepositoryRestResource(path = "proveedores")
public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer> {
	Page<Proveedor> findAll(Pageable page);
	Proveedor findByNombre(String nombre);
}
