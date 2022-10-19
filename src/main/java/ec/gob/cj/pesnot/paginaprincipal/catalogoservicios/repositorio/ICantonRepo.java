package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Canton;

@Repository
public interface ICantonRepo  extends JpaRepository<Canton,Long>{
	
	@Query(nativeQuery =true,value = "SELECT * FROM catalogoCanton p where p.IDPROVINCIA = :idProvincia and p.ESTADOCANTON=1;")
	List<Canton> getCantonesByProvincia(@Param("idProvincia") String idProvincia);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoCanton p WHERE p.NOMBRECANTON LIKE :nombre%")
	List<Canton> getCantonesLike(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoCanton where ESTADOCANTON='true'")
	List<Canton> getCantonesActivos();
	@Query(nativeQuery = true,value=
			"SELECT IDCANTON,ESTADOCANTON,NOMBRECANTON,c.IDPROVINCIA FROM catalogoCanton c join catalogoProvincia p on c.IDPROVINCIA=p.IDPROVINCIA where p.CODIGOPROVINCIA=:codigoProvincia")
	List<Canton> getCantonesByCodigoProvincia(@Param("codigoProvincia") String codigoProvincia);
	@Query(nativeQuery = true,value=
			"SELECT IDCANTON,ESTADOCANTON,NOMBRECANTON,c.IDPROVINCIA FROM catalogoCanton c join catalogoProvincia p on c.IDPROVINCIA=p.IDPROVINCIA where p.NOMBREPROVINCIA=:nombreProvincia")
	List<Canton> getCantonesByNombreProvincia(@Param("nombreProvincia") String nombreProvincia);
	

}
