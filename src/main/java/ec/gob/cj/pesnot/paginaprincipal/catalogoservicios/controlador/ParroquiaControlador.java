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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Parroquia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ParroquiaService;

@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ParroquiaControlador {
	
	@Autowired
	ParroquiaService parroquiaSvc;
	@GetMapping("/parroquias")
	public List<Parroquia> listarParroquia() {
		return parroquiaSvc.listarParroquia();
	}
	@GetMapping("/parroquias/activos")
	public List<Parroquia> listarParroquiasActivos() {
		List<Parroquia> result = null;
		result = parroquiaSvc.listarParroquiasActivos();
		return result;
	}

	@PostMapping("/parroquias")
	public Parroquia guardarParroquia(@RequestBody Parroquia objCanton) {

		return parroquiaSvc.guardarParroquia(objCanton);
	}

	@GetMapping("/parroquias/{id}")
	public Optional<Parroquia> obtenerParroquiaPorId(@PathVariable("id") Long id) {
		return parroquiaSvc.parroquiaById(id);
	}
	@GetMapping("/parroquias/nombre/{likeNombre}")
	public List<Parroquia> obtenerParroquiasLikeNombre(@PathVariable("likeNombre") String nombre) {
		return parroquiaSvc.getParroquiasLike(nombre);
	}
	@GetMapping("/parroquias/canton/{idCanton}")
	public List<Parroquia> obtenerParroquiasPorIdCanton(@PathVariable ("idCanton") String id) {
		return parroquiaSvc.getParroquiasByIdCanton(id);
	}
	@GetMapping("/parroquias/nombreCanton/{nombreCanton}")
	public List<Parroquia> obtenerParroquiasPorNombreCanton(@PathVariable ("nombreCanton") String nombreCanton) {
		return parroquiaSvc.getParroquiasByNombreCanton(nombreCanton);
	}
	


	
}
