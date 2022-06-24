package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.link.tpIntegradorLink.modelo.Carrito;

@RepositoryRestResource(path = "carritos")
@CrossOrigin("http://localhost:4200")
public interface RepoCarrito extends PagingAndSortingRepository<Carrito, Integer> {
	Page<Carrito> findAll(Pageable page);
}
