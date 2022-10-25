package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IPaisRepo;



@Service
@AllArgsConstructor
public class PaisService {
	@Autowired
	IPaisRepo repoPais;

	public List<Pais> listarPaises() {
		return repoPais.findAll();
	}

	public Pais guardarPais(Pais paisEntrante) {
		return repoPais.save(paisEntrante);
	}


	public Optional<Pais> paisById(Long idEntrante) {
		//El opcional me maneja si es que no encuentra nada
		Optional <Pais> pais = repoPais.findById(idEntrante);
		//.orElseThrow(()-> new CatalogoNotFoundException(idEntrante.toString()));
		return pais;
	}


	 public boolean eliminar(Long idClienteAEliminar) {
        try{
          repoPais.deleteById(idClienteAEliminar);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	public List<Pais> listarPaisesActivos(){
		return repoPais.getPaisesActivos();
	}
	 public List<Pais> getPaisesLikeNombre(String nombreCanton){
		 List<Pais> listaLikeNombrePais = new ArrayList<>();
		 listaLikeNombrePais=repoPais.getPaisesLikeNombre(nombreCanton);
		 return listaLikeNombrePais;
		 
	 }
	 public Pais getNombrePaisByCodigo(Long codigoPais) {
		 return repoPais.getNombrePaisByCodigo(codigoPais);
	 }
}
