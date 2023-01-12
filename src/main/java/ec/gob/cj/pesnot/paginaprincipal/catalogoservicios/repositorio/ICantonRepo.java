package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;

@Repository
public interface ICantonRepo  extends JpaRepository<Canton,Long>{
	
	@Query(nativeQuery =true,value = "SELECT * FROM catalogoCanton p where p.idProvincia = :idProvincia and p.estadoCanton=1;")
	List<Canton> getCantonesByProvincia(@Param("idProvincia") String idProvincia);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoCanton p WHERE p.nombreCanton LIKE :nombre%")
	List<Canton> getCantonesLike(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoCanton where estadoCanton='true'")
	List<Canton> getCantonesActivos();
	@Query(nativeQuery = true,value=
			"SELECT idCanton,estadoCanton,nombreCanton,c.idProvincia FROM catalogoCanton c join catalogoProvincia p on c.idProvincia=p.idProvincia where p.codigoProvincia=:codigoProvincia")
	List<Canton> getCantonesByCodigoProvincia(@Param("codigoProvincia") String codigoProvincia);
	@Query(nativeQuery = true,value=
			" idCanton,estadoCanton,nombreCanton,c.idProvincia FROM catalogoCanton c join catalogoProvincia p on c.idProvincia=p.idProvincia where p.nombreProvincia=:nombreProvincia")
	List<Canton> getCantonesByNombreProvincia(@Param("nombreProvincia") String nombreProvincia);
	

}
