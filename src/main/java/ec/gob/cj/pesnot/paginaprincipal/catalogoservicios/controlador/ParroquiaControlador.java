package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Parroquia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ParroquiaService;

@RequestMapping("/Parroquia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ParroquiaControlador {
	
	@Autowired
	ParroquiaService parroquiaSvc;
	@GetMapping("/parroquias")
	public List<Parroquia> listarParroquia() {
		return parroquiaSvc.listarParroquia();
	}
	@GetMapping("/parroquiasActivos")
	public List<Parroquia> listarParroquiasActivos() {
		List<Parroquia> result = null;
		result = parroquiaSvc.listarParroquiasActivos();
		return result;
	}

	@PostMapping("/save")
	public Parroquia guardarParroquia(@RequestBody Parroquia objCanton) {

		return parroquiaSvc.guardarParroquia(objCanton);
	}

	@GetMapping("/parroquias/{id}")
	public Optional<Parroquia> obtenerParroquiaPorId(@PathVariable("id") Long id) {
		return parroquiaSvc.parroquiaById(id);
	}
	@GetMapping("/parroquias/like/{likeNombre}")
	public List<Parroquia> obtenerParroquiasLike(@PathVariable("likeNombre") String nombre) {
		return parroquiaSvc.getParroquiasLike(nombre);
	}
	@GetMapping("/parroquias/Canton/{idCanton}")
	public List<Parroquia> getParroquiasByIdCanton(@PathVariable ("idCanton") String id) {
		return parroquiaSvc.getParroquiasByIdCanton(id);
	}
	@GetMapping("/parroquias/nombreCanton/{nombreCanton}")
	public List<Parroquia> getParroquiasByNombreCanton(@PathVariable ("nombreCanton") String nombreCanton) {
		return parroquiaSvc.getParroquiasByNombreCanton(nombreCanton);
	}
	


	@DeleteMapping("/parroquias/eliminar/{id}")
	    public String eliminarPorId(@PathVariable("id") Long id){
	        boolean ok = parroquiaSvc.eliminar(id);
	        if (ok){
	            return "Se eliminó el usuario con id " + id;
	        }else{
	            return "No pudo eliminar el usuario con id" + id;
	        }
	

}
	
}
