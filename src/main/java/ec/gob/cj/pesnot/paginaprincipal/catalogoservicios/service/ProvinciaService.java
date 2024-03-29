package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IProvinciaRepo;

@Service

public class ProvinciaService {
	@Autowired
	IProvinciaRepo repoProvincia;

	public List<Provincia> listarProvincias() {
		return repoProvincia.findAll();
	}

	public Provincia guardarProvincia(Provincia provinciaEntrante) {
		return repoProvincia.save(provinciaEntrante);
	}

	public Optional<Provincia> provinciaById(Long idEntrante) {
		// El opcional me maneja si es que no encuentra nada
		Optional<Provincia> provincia = repoProvincia.findById(idEntrante);
		// .orElseThrow(()-> new CatalogoNotFoundException(idEntrante.toString()));
		return provincia;
	}




	public List<Provincia> listarProvinciasActivos() {
		return repoProvincia.getProvinciasActivos();
	}

	public List<Provincia> getProvinciasLike(String nombrePais) {
		List<Provincia> listaLikeProvincia = new ArrayList<>();
		listaLikeProvincia = repoProvincia.getProvinciasLikeNombre(nombrePais);
		return listaLikeProvincia;

	}
	
	//TODO

	public List<Provincia> getProvinciasByIdPais(String idPais) {
		List<Provincia> listaByPais = new ArrayList<>();
		listaByPais = repoProvincia.getProvinciasByPais(idPais);
		return listaByPais;

	}

	public List<Provincia> getNombreProvinciaByCodigo(int codigoProvincia) {
		return repoProvincia.getNombreProvinciaByCodigo(codigoProvincia);
	}

	public List<Provincia> getProvinciasByCodigoPais(int codigoPais) {
		return repoProvincia.getProvinciasByCodigoPais(codigoPais);
	}

	public List<Provincia> getProvinciasByNombrePais(String nombrePais) {
		return repoProvincia.getProvinciasByNombrePais(nombrePais);
	}

}
