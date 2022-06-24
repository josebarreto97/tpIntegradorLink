package ar.edu.utn.link.tpIntegradorLink;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import ar.edu.utn.link.tpIntegradorLink.modelo.Cupon;
import ar.edu.utn.link.tpIntegradorLink.modelo.Membresia;
import ar.edu.utn.link.tpIntegradorLink.modelo.OrdenCompra;
import ar.edu.utn.link.tpIntegradorLink.modelo.Producto;
import ar.edu.utn.link.tpIntegradorLink.modelo.ProductoEnCantidad;
import ar.edu.utn.link.tpIntegradorLink.modelo.PromoMedioPago;
import ar.edu.utn.link.tpIntegradorLink.modelo.Promocion;
import ar.edu.utn.link.tpIntegradorLink.modelo.Proveedor;
import ar.edu.utn.link.tpIntegradorLink.modelo.TipoUsuario;
import ar.edu.utn.link.tpIntegradorLink.modelo.Usuario;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoCarrito;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoProducto;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoPromocion;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoProveedor;
import ar.edu.utn.link.tpIntegradorLink.repositorios.RepoUsuario;

@Component
public class InitData implements CommandLineRunner {

	@Autowired
	private RepoProveedor repoProveedores;
	
	@Autowired
	private RepoUsuario repoUsuarios;
	
	@Autowired
	private RepoProducto repoProductos;
	
	@Autowired
	private RepoCarrito repoCarritos;
	
	@Autowired
	private RepoPromocion repoPromociones;
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Proveedor.class);
		config.exposeIdsFor(Usuario.class);
		config.exposeIdsFor(Producto.class);
		config.exposeIdsFor(OrdenCompra.class);
		config.exposeIdsFor(ProductoEnCantidad.class);
		config.exposeIdsFor(Promocion.class);
		config.exposeIdsFor(Cupon.class);
		config.exposeIdsFor(Membresia.class);
		config.exposeIdsFor(PromoMedioPago.class);

		Proveedor unProveedor = new Proveedor("Hasbro");
		Proveedor otroProveedor = new Proveedor("ToyCo");
		Usuario nickBenve = new Usuario("nickBenve", "1234", "Nicolas", "Benvenaste", 12345678, true, TipoUsuario.CLIENTE);
		Usuario pato = new Usuario("pato", "1234", "Patricio", "Galli", 12345678, false, TipoUsuario.VENDEDOR);
		Producto producto1 = new Producto("Monopoly Simpsons", "Juego de Mesa divertido", 1.0, otroProveedor, "https://th.bing.com/th/id/R.1f5e065568fadec8772afc7f5c758ac5?rik=HtwSkwwCezoG0w&riu=http%3a%2f%2fwww.ovmpaper.ro%2fuserfiles%2fb9ac6e60-07a4-4e60-bbf9-a9c87fc63dfa%2fproducts%2f4339136_big.jpg&ehk=T8POFiBIMoCyJYc28yI6TdkIpdQ3iYwShILJozWbkrA%3d&risl=&pid=ImgRaw&r=0" );
		Producto producto2 = new Producto("UNO", "Juego de Cartas destruye amistades", 1.0, unProveedor, "https://www.drogariaminasbrasil.com.br/media/product/d70/chocolate-em-barra-arcor-ao-leite-100g-dd2.jpg");
		
		if(repoProveedores.count() == 0) {
			
			repoProveedores.save(unProveedor);
			repoProveedores.save(otroProveedor);
		}
		
		if(repoUsuarios.count() == 0) {
			repoUsuarios.save(nickBenve);
			repoUsuarios.save(pato);

		}
		
		if(repoProductos.count() == 0) {
			repoProductos.save(producto1);
			repoProductos.save(producto2);
		}
		
		if(repoPromociones.count() == 0) {
			Cupon cupon = new Cupon("Cupon 10% coca-cola", 10.0, true, "1234", otroProveedor, producto1);
			repoPromociones.save((Promocion) cupon);
		}
		
		
		

	}

}
