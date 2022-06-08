package ar.edu.utn.link.tpIntegradorLink.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Producto;

@RepositoryRestResource(path = "productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Long> {

	Optional<Producto> findByNombre(String nombre);

}