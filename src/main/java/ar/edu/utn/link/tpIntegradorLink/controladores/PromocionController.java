package ar.edu.utn.link.tpIntegradorLink.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.tpIntegradorLink.modelo.Promocion;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoPromocion;

@RepositoryRestController
public class PromocionController {

	@Autowired
	RepoPromocion repoPromociones;
	
	@RequestMapping(method = RequestMethod.GET, value = "/promociones/activas")
	public @ResponseBody List<Promocion> promocionesActivas() {
		List<Promocion> promocionesActivas = repoPromociones.findAllByEstaActivo(true);
		
		return promocionesActivas;
	}
}
