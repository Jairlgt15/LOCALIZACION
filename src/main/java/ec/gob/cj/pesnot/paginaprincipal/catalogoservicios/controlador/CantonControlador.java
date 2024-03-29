package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.CantonService;
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CantonControlador {
	@Autowired
	CantonService cantonSvc;
	@GetMapping("/cantones")
	public List<Canton> listarCantones() {
		return cantonSvc.listarCanton();
	}
	@GetMapping("/cantones/activos")
	public List<Canton> listarCantonesActivos() {
		List<Canton> result = null;
		result = cantonSvc.listarCantonesActivos();
		return result;
	}

	@PostMapping("/cantones")
	public Canton guardarCanton(@RequestBody Canton objCanton) {

		return cantonSvc.guardarCanton(objCanton);
	}

	@GetMapping("/cantones/{id}")
	public Optional<Canton> obtenerCantonPorId(@PathVariable("id") Long id) {
		return cantonSvc.cantonById(id);
	}
	@GetMapping("/cantones/nombre/{likeNombre}")
	public List<Canton> obtenerCantonesLikeNombre(@PathVariable("likeNombre") String nombre) {
		return cantonSvc.getCantonesLike(nombre);
	}
	@GetMapping("/cantones/provincia/{idProvincia}")
	public List<Canton> obtenerCantonesPorIdProvincia(@PathVariable ("idProvincia") String id) {
		return cantonSvc.getCantonesByIdProvincia(id);
	}
	@GetMapping("/cantones/codigoProvincia/{codigoProvincia}")
	public List<Canton> obtenerCantonesPorCodigoProvincia(@PathVariable ("codigoProvincia") String codigoProvincia) {
		return cantonSvc.getCantonesByCodigoProvincia(codigoProvincia);
	}
	@GetMapping("/cantones/nombreProvincia/{nombreProvincia}")
	public List<Canton> obtenerCantonesPorNombreProvincia(@PathVariable ("nombreProvincia") String nombreProvincia) {
		return cantonSvc.getCantonesByNombreProvincia(nombreProvincia);
	}

	

}
