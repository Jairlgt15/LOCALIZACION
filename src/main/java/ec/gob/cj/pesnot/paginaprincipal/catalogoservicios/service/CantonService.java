package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.ICantonRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CantonService {
	@Autowired
	ICantonRepo repoCanton;

	public List<Canton> listarCanton() {
		return repoCanton.findAll();
	}

	public Canton guardarCatalogo(Canton catalogoEntrante) {
		return repoCanton.save(catalogoEntrante);
	}


	public Optional<Canton> cantonById(Long idEntrante) {
		//El opcional me maneja si es que no encuentra nada
		Optional <Canton> catalogo = repoCanton.findById(idEntrante);
		//.orElseThrow(()-> new CatalogoNotFoundException(idEntrante.toString()));
		return catalogo;
	}

	public Canton actualizar(Canton catalagoAActualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	 public boolean eliminar(Long idClienteAEliminar) {
        try{
          repoCanton.deleteById(idClienteAEliminar);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	public List<Canton> listarCantonesActivos(){
		return repoCanton.getCantonesActivos();
	}
	 public List<Canton> getCantonesLike(String nombreCanton){
		 List<Canton> listaLikeCatalogo = new ArrayList<>();
		 listaLikeCatalogo=repoCanton.getCantonesLike(nombreCanton);
		 return listaLikeCatalogo;
		 
	 }
	 public List<Canton> getCantonesByIdProvincia(String idProvincia){
		 List<Canton> listaByProvincia = new ArrayList<>();
		 listaByProvincia=repoCanton.getCantonesByProvincia(idProvincia);
		 return listaByProvincia;
	 }	 
}
