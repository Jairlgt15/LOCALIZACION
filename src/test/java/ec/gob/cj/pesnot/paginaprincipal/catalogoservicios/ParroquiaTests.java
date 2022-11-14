package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.CantonControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.PaisControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.ParroquiaControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.ProvinciaControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Parroquia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.ICantonRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IPaisRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IParroquiaRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IProvinciaRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.CantonService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.PaisService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ParroquiaService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ProvinciaService;

@SpringBootTest
public class ParroquiaTests {

	@Autowired
	@Spy
	private ProvinciaService serviceProvincia = Mockito.mock(ProvinciaService.class);
	@Autowired
	@Spy
	private ProvinciaControlador controlProvincia = Mockito.mock(ProvinciaControlador.class);
	@Autowired
	@Spy
	private IProvinciaRepo repoProvincia = Mockito.mock(IProvinciaRepo.class);
	@Autowired
	@Spy
	private ICantonRepo repoCanton = Mockito.mock(ICantonRepo.class);
	@Autowired
	@Spy
	private CantonService serviceCanton = Mockito.mock(CantonService.class);
	@Autowired
	@Spy
	private CantonControlador controlCanton = Mockito.mock(CantonControlador.class);
	@Autowired
	@Spy
	private ParroquiaService service = Mockito.mock(ParroquiaService.class);
	@Autowired
	@Spy
	private ParroquiaControlador control = Mockito.mock(ParroquiaControlador.class);
	@Autowired
	@Spy
	private IParroquiaRepo repo = Mockito.mock(IParroquiaRepo.class);
	@Autowired
	@Spy
	private IPaisRepo repoPais = Mockito.mock(IPaisRepo.class);
	@Autowired
	@Spy
	private PaisService servicePais = Mockito.mock(PaisService.class);
	@Autowired
	@Spy
	private PaisControlador controlPais = Mockito.mock(PaisControlador.class);

	@Test
	@DisplayName("La prueba pasa cuando se liste los datos de pais.")
	void listarParroquia() {
		List<Parroquia> listaProvincia;
		control.listarParroquia();
		service.listarParroquia();
		listaProvincia = repo.findAll();
		assertNotNull(listaProvincia);
	}

	@Test
	@DisplayName("La prueba pasa cuando se liste los datos de pais que esten activos")
	void listarParroquiasActivos() {
		List<Parroquia> listarParroquiasActivos;
		control.listarParroquiasActivos();
		service.listarParroquiasActivos();
		listarParroquiasActivos = repo.getParroquiasActivos();
		assertNotNull(listarParroquiasActivos);
	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva la provincia que previamente se guardo")
	void guardarParroquia() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repoCanton.save(cantonGuardado);
		controlCanton.guardarCanton(cantonGuardado);

		Parroquia parroquiaGuardado = new Parroquia(cantonGuardado, "jair", true);
		Parroquia actual = repo.save(parroquiaGuardado);

		control.guardarParroquia(parroquiaGuardado);
		service.guardarParroquia(parroquiaGuardado);
		assertNotNull(actual);
		assertNotNull(actualCanton);
		assertNotNull(actualProvincia);

	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el id")
	void getProvinciaById() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repoCanton.save(cantonGuardado);
		serviceCanton.guardarCanton(cantonGuardado);
		controlCanton.guardarCanton(cantonGuardado);
		Parroquia parroquiaGuardado = new Parroquia(cantonGuardado, "jair", true);
		Parroquia actual = repo.save(parroquiaGuardado);
		control.obtenerParroquiaPorId(actual.getIdParroquia());
		service.parroquiaById(actual.getIdParroquia());
		Optional<Parroquia> parroquiaRecuperado = repo.findById(actual.getIdParroquia());
		assertNotNull(parroquiaRecuperado);
	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el nombre")
	void getParroquiaByNombre() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repoCanton.save(cantonGuardado);
		serviceCanton.guardarCanton(cantonGuardado);
		controlCanton.guardarCanton(cantonGuardado);
		Parroquia parroquiaGuardado = new Parroquia(cantonGuardado, "jair", true);
		Parroquia actual = repo.save(parroquiaGuardado);
		List<Parroquia> listaPaises;
		control.obtenerParroquiasLikeNombre(parroquiaGuardado.getNombreParroquia());
		service.getParroquiasLike(parroquiaGuardado.getNombreParroquia());
		listaPaises = repo.getParroquiasLike(parroquiaGuardado.getNombreParroquia());
		assertNotNull(listaPaises);
	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el id Pais")
	void getParroquiaByIdCanton() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repoCanton.save(cantonGuardado);
		serviceCanton.guardarCanton(cantonGuardado);
		controlCanton.guardarCanton(cantonGuardado);
		Parroquia parroquiaGuardado = new Parroquia(cantonGuardado, "jair", true);
		Parroquia actual = repo.save(parroquiaGuardado);
		List<Parroquia> listaPaises;
		listaPaises = repo.getParroquiasByIdCanton(actualCanton.getIdCanton().toString());

		assertNotNull(listaPaises);
		service.getParroquiasByIdCanton(actualCanton.getIdCanton().toString());
		control.obtenerParroquiasPorIdCanton(actualCanton.getIdCanton().toString());

	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el codigo de Pais")
	void getParroquiaByNombreCanton() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repoCanton.save(cantonGuardado);
		serviceCanton.guardarCanton(cantonGuardado);
		controlCanton.guardarCanton(cantonGuardado);
		Parroquia parroquiaGuardado = new Parroquia(cantonGuardado, "jair", true);
		Parroquia actual = repo.save(parroquiaGuardado);
		List<Parroquia> listaPaises;
		listaPaises = repo.getParroquiasByNombreCanton(actualCanton.getNombreCanton());

		assertNotNull(listaPaises);
		service.getParroquiasByNombreCanton(actualCanton.getIdCanton().toString());
		control.obtenerParroquiasPorNombreCanton(actualCanton.getIdCanton().toString());
		
	}
	
	

	@Test

	@DisplayName("La prueba pasa cuando se instancie todo lo relacionado al modelo")
	void modeloParroquia() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repoCanton.save(cantonGuardado);
		serviceCanton.guardarCanton(cantonGuardado);
		controlCanton.guardarCanton(cantonGuardado);
		Parroquia parroquiaGuardado = new Parroquia(cantonGuardado, "jair", true);
		Parroquia parroquiaGuardado1 = new Parroquia(20l,cantonGuardado, "jair", true);
		parroquiaGuardado.setEstadoParroquia(false);
		parroquiaGuardado.setIdCanton(actualCanton);
		parroquiaGuardado.setIdParroquia(20l);
		parroquiaGuardado.setNombreParroquia(null);
		assertNotNull(parroquiaGuardado.getIdParroquia());
		parroquiaGuardado.getNombreParroquia();
		parroquiaGuardado.getIdCanton();
		parroquiaGuardado.toString();
		parroquiaGuardado.isEstadoParroquia();

	}

}
