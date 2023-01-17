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
	public List<Provincia> obtenerProvinciaLikeNombre(@PathVariable("likeNombre") String nombre) {
		return provinciaSvc.getProvinciasLike(nombre);
	}

	@GetMapping("/provincias/Pais/{idPais}")
	public List<Provincia> obtenerProvinciasPorIdPais(@PathVariable("idPais") String id) {
		return provinciaSvc.getProvinciasByIdPais(id);
	}

	@GetMapping("/provincias/buscarByCodigo/{codigoProvincia}")
	public List<Provincia> obtenerNombreProvinciaPorCodigo(@PathVariable("codigoProvincia") int codigo) {
		return provinciaSvc.getNombreProvinciaByCodigo(codigo);
	}

	@GetMapping("/provincias/codigoPais/{codigoPais}")
	public List<Provincia> obtenerProvinciasPorCodigoPais(@PathVariable("codigoPais") int codigoPais) {
		return provinciaSvc.getProvinciasByCodigoPais(codigoPais);
	}

	@GetMapping("/provincias/nombrePais/{nombrePais}")
	public List<Provincia> obtenerProvinciasPorNombrePais(@PathVariable("nombrePais") String nombrePais) {
		return provinciaSvc.getProvinciasByNombrePais(nombrePais);
	}

}
