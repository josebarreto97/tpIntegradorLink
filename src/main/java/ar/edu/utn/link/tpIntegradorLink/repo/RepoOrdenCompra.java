package ar.edu.utn.link.tpIntegradorLink.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.OrdenCompra;

@RepositoryRestResource(path = "ordenesCompra")
public interface RepoOrdenCompra extends PagingAndSortingRepository<OrdenCompra, Long> {
}
