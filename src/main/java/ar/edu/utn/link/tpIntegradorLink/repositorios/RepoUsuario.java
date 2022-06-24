package ar.edu.utn.link.tpIntegradorLink.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.tpIntegradorLink.modelo.Carrito;
import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer> {
	Page<Usuario> findAll(Pageable page);
	
	Usuario findByUser(String user);
	Usuario findByUserAndPassword(String user, String password);
	Usuario findByCarrito(Carrito carrito);
	
	@Override
	@RestResource(exported = false)
	default void deleteById(Integer id){
		// TODO Auto-generated method stub
	}

	@Override
	@RestResource(exported = false)
	default void delete(Usuario entity){
		// TODO Auto-generated method stub
	}
	
}
