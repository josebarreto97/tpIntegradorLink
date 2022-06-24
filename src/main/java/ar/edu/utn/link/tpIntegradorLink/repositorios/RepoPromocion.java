package ar.edu.utn.link.tpIntegradorLink.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Promocion;

@RepositoryRestResource(path = "promociones")
public interface RepoPromocion extends PagingAndSortingRepository<Promocion, Integer> {
	List<Promocion> findAllByEstaActivo(boolean estaActivo);
}
