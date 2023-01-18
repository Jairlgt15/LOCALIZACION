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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.PaisService;

@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class PaisControlador {
	@Autowired
	PaisService paisSvc;
	@GetMapping("/paises")
	public List<Pais> listarPaises() {
		return paisSvc.listarPaises();
	}
	@GetMapping("/paises/activos")
	public List<Pais> listarPaisesActivos() {
		List<Pais> result = null;
		result = paisSvc.listarPaisesActivos();
		return result;
	}

	@PostMapping("/paises")
	public Pais guardarPais(@RequestBody Pais objPais) {

		return paisSvc.guardarPais(objPais);
	}

	@GetMapping("/paises/{id}")
	public Optional<Pais> obtenerPaisPorId(@PathVariable("id") Long id) {
		return paisSvc.paisById(id);
	}
	@GetMapping("/paises/nombre/{likeNombre}")
	public List<Pais> obtenerPaisesLikeNombre(@PathVariable("likeNombre") String nombre) {
		return paisSvc.getPaisesLikeNombre(nombre);
	}
	@GetMapping("/paises/provincias/{codigoPais}")
	 public Pais obtenerNombreProvinciaPorCodigo(@PathVariable("codigoPais") int i) {
		 return paisSvc.getNombrePaisByCodigo(i);
	 }


	@DeleteMapping("/paises/{id}")
	    public String eliminarPorId(@PathVariable("id") Long id){
	        boolean ok = paisSvc.eliminar(id);
	        if (ok){
	            return "Se eliminó el usuario con id " + id;
	        }else{
	            return "No pudo eliminar el usuario con id" + id;
	        }
	

}

}
