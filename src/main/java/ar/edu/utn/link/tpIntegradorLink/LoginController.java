package ar.edu.utn.link.tpIntegradorLink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoUsuario;

@RestController
public class LoginController {

	@Autowired
	RepoUsuario repoUsuarios;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/obtenerUsuario")
	public @ResponseBody Usuario obtenerUsuario(@RequestBody Login datosLogin) {
	
		
		Usuario usuarioEncontrado = repoUsuarios.findByUserAndPassword(datosLogin.getUsuario(), datosLogin.getPassword());
		if(usuarioEncontrado == null) {
			System.out.println("Usuario no encontrado");

			return null;
		}
		

		return usuarioEncontrado;

	}
}
