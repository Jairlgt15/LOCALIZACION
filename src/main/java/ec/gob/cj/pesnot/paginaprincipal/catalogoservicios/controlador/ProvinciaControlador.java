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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ProvinciaService;


@RequestMapping("/Provincia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProvinciaControlador {
	@Autowired
	ProvinciaService provinciaSvc;
	@GetMapping("/provincias")
	public List<Provincia> listarProvincia() {
		return provinciaSvc.listarProvincias();
	}
	@GetMapping("/provinciasActivos")
	public List<Provincia> listarProvinciasActivos() {
		List<Provincia> result = null;
		result = provinciaSvc.listarProvinciasActivos();
		return result;
	}

	@PostMapping("/save")
	public Provincia guardarProvincia(@RequestBody Provincia objProvincia) {

		return provinciaSvc.guardarProvincia(objProvincia);
	}

	@GetMapping("/provincias/{id}")
	public Optional<Provincia> obtenerProvinciaPorId(@PathVariable("id") Long id) {
		return provinciaSvc.provinciaById(id);
	}
	@GetMapping("/provincias/like/{likeNombre}")
	public List<Provincia> obtenerProvinciaLike(@PathVariable("likeNombre") String nombre) {
		return provinciaSvc.getProvinciasLike(nombre);
	}
	@GetMapping("/provincias/Pais/{idPais}")
	public List<Provincia> getProvinciasByPais(@PathVariable ("idPais") String id) {
		return provinciaSvc.getProvinciasByIdPais(id);
	}
	@GetMapping("/provincias/buscarByCodigo/{codigoProvincia}")
	 public Provincia getNombreProvinciaByCodigo(@PathVariable("codigoProvincia") String codigo) {
		 return provinciaSvc.getNombreProvinciaByCodigo(codigo);
	 }
	@GetMapping("/provincias/codigoPais/{codigoPais}")
	public List<Provincia> getProvinciasByNombrePais(@PathVariable ("codigoPais") String codigoPais) {
		return provinciaSvc.getProvinciasByCodigoPais(codigoPais);
	}
	@GetMapping("/provincias/nombrePais/{nombrePais}")
	public List<Provincia> getProvinciasByCodigoPais(@PathVariable ("nombrePais") String nombrePais) {
		return provinciaSvc.getProvinciasByNombrePais(nombrePais);
	}


	@DeleteMapping("/provincias/eliminar/{id}")
	    public String eliminarPorId(@PathVariable("id") Long id){
	        boolean ok = provinciaSvc.eliminar(id);
	        if (ok){
	            return "Se eliminó el usuario con id " + id;
	        }else{
	            return "No pudo eliminar el usuario con id" + id;
	        }
}

}
