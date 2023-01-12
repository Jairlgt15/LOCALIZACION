package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Parroquia;

@Repository
public interface IParroquiaRepo  extends JpaRepository<Parroquia,Long> {
	//aqui van los querys
	@Query(nativeQuery =true,value = "SELECT * FROM catalogoParroquia p where p.idCanton = :idCanton and p.estadoParroquia=1;")
	List<Parroquia> getParroquiasByIdCanton(@Param("idCanton") String idCanton);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoParroquia p WHERE p.NOMBREPARROQUIA LIKE :nombre%")
	List<Parroquia> getParroquiasLike(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoParroquia where ESTADOPARROQUIA='true'")
	List<Parroquia> getParroquiasActivos();
	@Query(nativeQuery = true,value=
			"SELECT p.idParroquia, p.estadoParroquia, p.nombreParroquia, p.idCanton FROM catalogoParroquia p join catalogoCanton c on c.idCanton=p.idCanton where c.nombreCanton=:nombreCanton")
	List<Parroquia> getParroquiasByNombreCanton(@Param("nombreCanton") String nombreCanton);
}