package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Cupon;

@RepositoryRestResource(path = "promosCupon")
public interface RepoCupon extends PagingAndSortingRepository<Cupon, Integer> {

	Cupon findByCodigo(String codigo);
}
