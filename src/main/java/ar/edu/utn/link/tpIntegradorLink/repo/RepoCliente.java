package ar.edu.utn.link.tpIntegradorLink.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Cliente;

@RepositoryRestResource(path = "clientes")
public interface RepoCliente extends PagingAndSortingRepository<Cliente, Long> {

	Optional<Cliente> findByUsernameAndPassword(String username, String password);

	Optional<Cliente> findByUsuario(String username);
}
