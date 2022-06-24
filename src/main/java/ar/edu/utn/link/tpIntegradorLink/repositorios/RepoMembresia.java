package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Membresia;

@RepositoryRestResource(path = "promosMembresia")
public interface RepoMembresia extends PagingAndSortingRepository<Membresia, Integer> {
	//
}
