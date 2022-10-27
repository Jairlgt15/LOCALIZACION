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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.PaisControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.ProvinciaControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IPaisRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IProvinciaRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.PaisService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ProvinciaService;
@SpringBootTest
public class ProvinciaTests {


	@Autowired
	@Spy
	private ProvinciaService service = Mockito.mock(ProvinciaService.class);
	
	@Autowired
	@Spy
	private ProvinciaControlador control = Mockito.mock(ProvinciaControlador.class);
	
	@Autowired
	@Spy
	private IProvinciaRepo repo = Mockito.mock(IProvinciaRepo.class);
	
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
	void listarProvincias() {
		List<Provincia> listaProvincia;
		control.listarProvincia();
		service.listarProvincias();
		listaProvincia = repo.findAll();
		assertNotNull(listaProvincia);
	}
	@Test
	@DisplayName("La prueba pasa cuando se liste los datos de pais que esten activos")
	void listarProvinciasActivos() {
		List <Provincia> listarProvinciasActivos;
		control.listarProvinciasActivos();
		service.listarProvinciasActivos();
		listarProvinciasActivos = repo.getProvinciasActivos();
		assertNotNull(listarProvinciasActivos);
	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que previamente se guardo")
	void guardarProvincia() {
		Pais paisGuardado=new Pais(87l,"EEUU", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
        Provincia actual = repo.save(provinciaGuardado);
		control.guardarProvincia(provinciaGuardado);
		service.guardarProvincia(provinciaGuardado);
        assertThat(actual).isNotNull();
        
	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el id")
	void getProvinciaById() {
		Pais paisGuardado=new Pais(1l,"Bahamas", true);
		repoPais.save(paisGuardado);
		
		Provincia provinciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
		Optional<Provincia> provinciaRecuperado;
		repo.save(provinciaGuardado);
		control.obtenerProvinciaPorId(provinciaGuardado.getIdProvincia());
		service.provinciaById(provinciaGuardado.getIdProvincia());
		provinciaRecuperado=repo.findById(provinciaGuardado.getIdProvincia());
		assertNotNull(provinciaRecuperado);
	}
	
	@Test
	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el nombre")
	void getProvinciaByNombre() {
		Pais paisGuardado=new Pais(55l,"Brasil", true);
		repoPais.save(paisGuardado);
		
		Provincia proviniciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
		List <Provincia> listaPaises;
		repo.save(proviniciaGuardado);
		control.obtenerProvinciaLike(proviniciaGuardado.getNombreProvincia());
		service.getProvinciasLike(proviniciaGuardado.getNombreProvincia());
		listaPaises=repo.getProvinciasLikeNombre(proviniciaGuardado.getNombreProvincia());
		assertNotNull(listaPaises);
	}
	
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el codigo")
	void getProvinciaByCodigo() {
		Pais paisGuardado=new Pais(86l,"China", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
		List <Provincia> listaPaises;
		Provincia provinciaGuardadoR=repo.save(provinciaGuardado);
		listaPaises=repo.getNombreProvinciaByCodigo(provinciaGuardadoR.getCodigoProvincia());

		assertNotNull(listaPaises);
		service.getNombreProvinciaByCodigo(provinciaGuardadoR.getCodigoProvincia());
		control.getNombreProvinciaByCodigo(provinciaGuardadoR.getCodigoProvincia());

	}
	
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el id Pais")
	void getProvinciaByIdPais() {
		Pais paisGuardado=new Pais(86l,"China", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
		List <Provincia> listaPaises;
		Provincia provinciaGuardadoR=repo.save(provinciaGuardado);
		listaPaises=repo.getProvinciasByPais(provinciaGuardadoR.getIdPais().getIdPais().toString());

		assertNotNull(listaPaises);
		service.getProvinciasByIdPais(provinciaGuardadoR.getIdPais().getIdPais().toString());
		control.getProvinciasByIdPais(provinciaGuardadoR.getIdPais().getIdPais().toString());

	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el codigo de Pais")
	void getProvinciaByCodigoPais() {
		Pais paisGuardado=new Pais(86l,"China", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
		List <Provincia> listaPaises;
		Provincia provinciaGuardadoR=repo.save(provinciaGuardado);
		listaPaises=repo.getProvinciasByCodigoPais(paisGuardado.getCodigoPais());

		assertNotNull(listaPaises);
		service.getProvinciasByCodigoPais(paisGuardado.getCodigoPais());
		control.getProvinciasByCodigoPais(paisGuardado.getCodigoPais());

	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva la provincia que se busca mediante el nombre de Pais")
	void getProvinciaByNombrePais() {
		Pais paisGuardado=new Pais(86l,"China", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado=new Provincia(paisGuardado,17l,"Antofagasta",false);
		List <Provincia> listaPaises;
		Provincia provinciaGuardadoR=repo.save(provinciaGuardado);
		listaPaises=repo.getProvinciasByCodigoPais(paisGuardado.getCodigoPais());

		assertNotNull(listaPaises);
		service.getProvinciasByNombrePais(paisGuardado.getNacionalidad());
		control.getProvinciasByNombrePais(paisGuardado.getNacionalidad());
	}


	@Test
	@DisplayName("La prueba pasa cuando se instancie todo lo relacionado al modelo")
	void modeloProvincia() {
		Pais paisGuardado=new Pais(63l,"Filipinas", true);
		repoPais.save(paisGuardado);
		Provincia provinciaGuardado=new Provincia(12l,paisGuardado,17l,"Antofagasta",false);
		provinciaGuardado.setCodigoProvincia(1l);
		provinciaGuardado.setEstadoProvincia(false);
		provinciaGuardado.setIdProvincia(1l);
		provinciaGuardado.setNombreProvincia("Catar");
		provinciaGuardado.setIdPais(null);
		provinciaGuardado.getIdPais();
		assertNotNull(provinciaGuardado.getCodigoProvincia());
		assertNotNull(provinciaGuardado.isEstadoProvincia());
		provinciaGuardado.toString();


	}
	

}
