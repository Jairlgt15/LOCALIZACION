package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.PaisControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IPaisRepo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.PaisService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//debemos mapear la clase a public para hacer el ejecutable
@SpringBootTest

public class PaisTests {

	@Mock
	private SpringApplicationBuilder springApplicationBuilder;
	@Autowired
	@Spy
	private PaisService service = Mockito.mock(PaisService.class);
	@Autowired
	@Spy
	private PaisControlador control = Mockito.mock(PaisControlador.class);
	@Autowired
	@Spy
	private IPaisRepo repo = Mockito.mock(IPaisRepo.class);

	@Test
	public void main() {
		LocalizacionApplication.main(new String[] {});
	}

	@Test
	public void testIt() {
		LocalizacionApplication notificacionesApplication = new LocalizacionApplication();
		when(springApplicationBuilder.sources(LocalizacionApplication.class)).thenReturn(springApplicationBuilder);

		SpringApplicationBuilder result = notificacionesApplication.configure(springApplicationBuilder);

		verify(springApplicationBuilder).sources(LocalizacionApplication.class);
		assertEquals(springApplicationBuilder, result);
	}

	@Test
	@DisplayName("La prueba pasa cuando se liste los datos de pais.")
	void listarPaises() {
		List<Pais> listaPaises;
		control.listarPaises();
		service.listarPaises();
		listaPaises = repo.findAll();
		assertNotNull(listaPaises);
	}
	@Test
	@DisplayName("La prueba pasa cuando se liste los datos de pais que esten activos")
	void listarPaisesActivos() {
		List <Pais> listaPaisesActivos;
		control.listarPaisesActivos();
		service.listarPaisesActivos();
		listaPaisesActivos = repo.getPaisesActivos();
		assertNotNull(listaPaisesActivos);
	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva el pais que previamente se guardo")
	void guardarPais() {
		Pais paisGuardado=new Pais(54l,"chileno", true);
		Pais paisGuardadoR;
		control.guardarPais(paisGuardado);
		service.guardarPais(paisGuardado);
		paisGuardadoR = repo.save(paisGuardado);
		assertNotNull(paisGuardadoR);
	}
	@Test
	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el id")
	void getPaisById() {
		Pais paisGuardado=new Pais(54l,"chileno", true);
		Optional<Pais> paisRecuperado;
		repo.save(paisGuardado);
		control.obtenerPaisPorId(paisGuardado.getIdPais());
		service.paisById(paisGuardado.getIdPais());
		paisRecuperado=repo.findById(paisGuardado.getIdPais());
		assertNotNull(paisRecuperado);
	}
	
	@Test
	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el nombre")
	void getPaisByNombre() {
		Pais paisGuardado=new Pais(54l,"chileno", true);
		List <Pais> listaPaises;
		repo.save(paisGuardado);
		control.obtenerPaisesLikeNombre(paisGuardado.getNacionalidad());
		service.getPaisesLikeNombre(paisGuardado.getNacionalidad());
		listaPaises=repo.getPaisesLikeNombre(paisGuardado.getNacionalidad());
		assertNotNull(listaPaises);
	}
	
	@Test
	@DisplayName("La prueba pasa cuando se devuelva el pais que se busca mediante el codigo")
	void getPaisByCodigo() {
		Long numero=54l;
		Pais paisGuardado=new Pais(numero,"chileno", true);
		Pais paisRecuperado;
		Pais paisGuardadoR;
		paisGuardadoR=repo.save(paisGuardado);
		System.out.println(paisGuardadoR);
		String codigo=numero+"";

		control.getNombreProvinciaByCodigo(paisGuardadoR.getCodigoPais());
		service.getNombrePaisByCodigo(paisGuardadoR.getCodigoPais());
		paisRecuperado=repo.getNombrePaisByCodigo(paisGuardadoR.getCodigoPais());

		assertNotNull(paisRecuperado);
	}
	
	@Test
	@DisplayName("La prueba pasa cuando se elimine el pais que se busca mediante el codigo")
	void eliminarPaisById() {
		Pais paisGuardado=new Pais(54l,"chileno", true);
		repo.save(paisGuardado);
		control.eliminarPorId(paisGuardado.getIdPais());
		control.eliminarPorId(paisGuardado.getIdPais()+1);
		service.eliminar(paisGuardado.getIdPais());

	}
	@Test
	@DisplayName("La prueba pasa cuando se instancie todo lo relacionado al modelo")
	void modeloPais() {
		Pais paisGuardado=new Pais(3l,54l,"chileno", true);
		paisGuardado.setCodigoPais(1l);
		paisGuardado.setEstadoNacionalidad(false);
		paisGuardado.setIdPais(1l);
		paisGuardado.setNacionalidad("Catar");
		assertNotNull(paisGuardado.getCodigoPais());
		assertNotNull(paisGuardado.isEstadoNacionalidad());
		paisGuardado.toString();


	}
	
	

}
