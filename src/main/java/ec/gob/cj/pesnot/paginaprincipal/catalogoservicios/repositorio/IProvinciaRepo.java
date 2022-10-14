package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;

@Repository
public interface IProvinciaRepo  extends JpaRepository<Provincia,Long> {
	
	@Query(nativeQuery =true,value = "SELECT * FROM provincia p where p.IDPAIS = :idPais and p.ESTADOPROVINCIA=1;")
	List<Provincia> getProvinciasByPais(@Param("idPais") String idPais);
	
	@Query(nativeQuery = true,value="SELECT * FROM provincia p WHERE p.NOMBREPROVINCIA LIKE :nombre%")
	List<Provincia> getProvinciasLikeNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM provincia where ESTADOPROVINCIA='true'")
	List<Provincia> getProvinciasActivos();

}