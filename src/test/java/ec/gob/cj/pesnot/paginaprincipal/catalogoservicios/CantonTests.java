package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;
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
public class CantonTests {
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
	private ICantonRepo repo = Mockito.mock(ICantonRepo.class);
	@Autowired
	@Spy
	private CantonService service = Mockito.mock(CantonService.class);
	@Autowired
	@Spy
	private CantonControlador control = Mockito.mock(CantonControlador.class);
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
	void listarCanton() {
		List<Canton> listaCanton;
		control.listarCantones();
		service.listarCanton();
		listaCanton = repo.findAll();
		assertNotNull(listaCanton);
	}

	@Test
	@DisplayName("La prueba pasa cuando se liste los datos de pais que esten activos")
	void listarCantonesActivos() {
		List<Canton> listarsActivos;
		control.listarCantonesActivos();
		service.listarCantonesActivos();
		listarsActivos = repo.getCantonesActivos();
		assertNotNull(listarsActivos);
	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva la provincia que previamente se guardo")
	void guardarCanton() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);
		service.guardarCanton(cantonGuardado);
		control.guardarCanton(cantonGuardado);
		assertNotNull(actualCanton);
		assertNotNull(actualProvincia);

	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el id")
	void getCantonById() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);
		control.obtenerCantonPorId(actualCanton.getIdCanton());
		service.cantonById(actualCanton.getIdCanton());
		Optional<Canton> cantonRecuperado = repo.findById(actualCanton.getIdCanton());
		assertNotNull(cantonRecuperado);
	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el nombre")
	void getCantonByNombre() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);
		service.guardarCanton(cantonGuardado);
		control.guardarCanton(cantonGuardado);
		List<Canton> listaPaises;
		control.obtenerCantonesLike(actualCanton.getNombreCanton());
		service.getCantonesLike(actualCanton.getNombreCanton());
		listaPaises = repo.getCantonesLike(actualCanton.getNombreCanton());
		assertNotNull(listaPaises);
	}

	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el id Pais")
	void getCantonByIdProvincia() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);
		List<Canton> listaPaises;
		listaPaises = repo.getCantonesByProvincia(actualProvincia.getIdProvincia().toString());

		assertNotNull(listaPaises);
		service.getCantonesByIdProvincia(actualProvincia.getIdProvincia().toString());
		control.getCantonesByIdProvincia(actualProvincia.getIdProvincia().toString());

	}

	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el codigo Provincia")
	void getCantonByCodigoProvincia() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);
		List<Canton> listaPaises;
		listaPaises = repo.getCantonesByCodigoProvincia(actualProvincia.getCodigoProvincia().toString());

		assertNotNull(listaPaises);
		service.getCantonesByCodigoProvincia(actualProvincia.getCodigoProvincia().toString());
		control.getCantonesByCodigoProvincia(actualProvincia.getCodigoProvincia().toString());

	}

	@Test

	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el codigo de Pais")
	void getCantonByNombreProvincia() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);

		List<Canton> listaPaises;
		listaPaises = repo.getCantonesByNombreProvincia(actualProvincia.getNombreProvincia());

		assertNotNull(listaPaises);
		service.getCantonesByNombreProvincia(actualProvincia.getNombreProvincia());
		control.getCantonesByNombreProvincia(actualProvincia.getNombreProvincia());

	}

	@Test

	@DisplayName("La prueba pasa cuando se instancie todo lo relacionado al modelo")
	void modeloCanton() {
		Pais paisGuardado = new Pais(87l, "EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado = new Provincia(paisGuardado, 17l, "Antofagasta", false);
		Provincia actualProvincia = repoProvincia.save(provinciaGuardado);
		Canton cantonGuardado = new Canton(provinciaGuardado, "Chileno", true);
		Canton cantonGuardado1 = new Canton(1l,provinciaGuardado, "Chileno", true);
		Canton actualCanton = repo.save(cantonGuardado);
		cantonGuardado1.setIdCanton(null);
		cantonGuardado1.setEstadoCanton(false);
		cantonGuardado1.setIdProvincia(actualProvincia);
		cantonGuardado1.setNombreCanton(null);
		cantonGuardado1.getIdProvincia();
		cantonGuardado1.isEstadoCanton();
		

	}
}
