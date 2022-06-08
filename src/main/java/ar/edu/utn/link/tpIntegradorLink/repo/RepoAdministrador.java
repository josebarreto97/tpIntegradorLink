package ar.edu.utn.link.tpIntegradorLink.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Administrador;

@RepositoryRestResource(path = "administradores")
public interface RepoAdministrador extends PagingAndSortingRepository<Administrador, Long> {

	Optional<Administrador> findByUsernameAndPassword(String username, String password);

	Optional<Administrador> findByUsuario(String username);
}
