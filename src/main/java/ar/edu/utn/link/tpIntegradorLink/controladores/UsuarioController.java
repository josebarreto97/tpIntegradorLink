package ar.edu.utn.link.tpIntegradorLink.controladores;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.tpIntegradorLink.modelo.Carrito;
import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoUsuario;

@RepositoryRestController
public class UsuarioController {
	@Autowired
	RepoUsuario repoUsuarios;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios")
	public @ResponseBody String agregarUsuario(@RequestBody Usuario usuario) {
		
		usuario.setCarrito(new Carrito());
		
		repoUsuarios.save(usuario);
		
		return "Usuario creado";	
	}
}
