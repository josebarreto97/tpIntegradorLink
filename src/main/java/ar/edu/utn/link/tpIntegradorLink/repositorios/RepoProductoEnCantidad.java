package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ar.edu.utn.link.tpIntegradorLink.modelo.ProductoEnCantidad;

@RepositoryRestResource(path = "productosXCant")
public interface RepoProductoEnCantidad extends PagingAndSortingRepository<ProductoEnCantidad, Integer> {

}
