package ar.edu.utn.link.tpIntegradorLink.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.link.tpIntegradorLink.modelo.Producto;

@RepositoryRestResource(path = "productos")
@CrossOrigin("http://localhost:4200")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {

	List<Producto> findAll();
	
	List<Producto> findAllByNombre(String nombre);
	
	Page<Producto> findAllByHabilitado(boolean habilitado, Pageable page);
	
	Producto findByNombre(String nombre);
	
}
