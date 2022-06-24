package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.link.tpIntegradorLink.modelo.OrdenCompra;

@RepositoryRestResource(path = "ordenesDeCompra")
@CrossOrigin("http://localhost:4200")
public interface RepoOrdenesCompra extends PagingAndSortingRepository<OrdenCompra, Integer> {

}
