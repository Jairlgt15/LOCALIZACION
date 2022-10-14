package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Parroquia;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio.IParroquiaRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParroquiaService {
	@Autowired
	IParroquiaRepo repoParroquia;

	public List<Parroquia> listarParroquia() {
		return repoParroquia.findAll();
	}

	public Parroquia guardarParroquia(Parroquia catalogoEntrante) {
		return repoParroquia.save(catalogoEntrante);
	}


	public Optional<Parroquia> parroquiaById(Long idEntrante) {
		//El opcional me maneja si es que no encuentra nada
		Optional <Parroquia> parroquia = repoParroquia.findById(idEntrante);
		//.orElseThrow(()-> new CatalogoNotFoundException(idEntrante.toString()));
		return parroquia;
	}

	public Parroquia actualizar(Parroquia catalagoAActualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	 public boolean eliminar(Long idClienteAEliminar) {
        try{
          repoParroquia.deleteById(idClienteAEliminar);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	public List<Parroquia> listarParroquiasActivos(){
		return repoParroquia.getParroquiasActivos();
	}
	 public List<Parroquia> getProvinciaLike(String nombreCanton){
		 List<Parroquia> listaLikeParroquia = new ArrayList<>();
		 listaLikeParroquia=repoParroquia.getParroquiasLike(nombreCanton);
		 return listaLikeParroquia;
		 
	 }
	 public List<Parroquia> getParroquiasByIdCanton(String idProvincia){
		 List<Parroquia> listaByCantones = new ArrayList<>();
		 listaByCantones=repoParroquia.getParroquiasByCantones(idProvincia);
		 return listaByCantones;
	 }	 
}
