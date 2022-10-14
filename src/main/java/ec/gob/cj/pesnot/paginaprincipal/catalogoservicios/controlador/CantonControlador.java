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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.CantonService;
@RequestMapping("/canton")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CantonControlador {
	@Autowired
	CantonService cantonSvc;
	@GetMapping("/cantones")
	public List<Canton> listarCantones() {
		return cantonSvc.listarCanton();
	}
	@GetMapping("/cantonesActivos")
	public List<Canton> listarCantonesActivos() {
		List<Canton> result = null;
		result = cantonSvc.listarCantonesActivos();
		return result;
	}

	@PostMapping("/save")
	public Canton guardarCanton(@RequestBody Canton objCanton) {

		return cantonSvc.guardarCatalogo(objCanton);
	}

	@GetMapping("/cantones/{id}")
	public Optional<Canton> obtenerCantonPorId(@PathVariable("id") Long id) {
		return cantonSvc.cantonById(id);
	}
	@GetMapping("/cantones/like/{likeNombre}")
	public List<Canton> obtenerCantonesLike(@PathVariable("likeNombre") String nombre) {
		return cantonSvc.getCantonesLike(nombre);
	}


	@DeleteMapping("/cantones/eliminar/{id}")
	    public String eliminarPorId(@PathVariable("id") Long id){
	        boolean ok = cantonSvc.eliminar(id);
	        if (ok){
	            return "Se eliminó el usuario con id " + id;
	        }else{
	            return "No pudo eliminar el usuario con id" + id;
	        }
	

}
	

}
