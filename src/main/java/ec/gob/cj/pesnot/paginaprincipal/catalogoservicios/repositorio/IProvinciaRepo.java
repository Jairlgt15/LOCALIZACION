package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;

@Repository
public interface IProvinciaRepo  extends JpaRepository<Provincia,Long> {
	
	@Query(nativeQuery =true,value = "SELECT * FROM catalogoProvincia p where p.IDPAIS = :idPais and p.ESTADOPROVINCIA=1;")
	List<Provincia> getProvinciasByPais(@Param("idPais") String idPais);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoProvincia p WHERE p.NOMBREPROVINCIA LIKE :nombre%")
	List<Provincia> getProvinciasLikeNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoProvincia where ESTADOPROVINCIA='true'")
	List<Provincia> getProvinciasActivos();
	@Query(nativeQuery = true,value="SELECT * from catalogoProvincia where CODIGOPROVINCIA = :codigoProvincia")
	Provincia getNombreProvinciaByCodigo(@Param("codigoProvincia") Long codigoProvincia);
	
	@Query(nativeQuery = true,value=
			"SELECT v.IDPROVINCIA, v.CODIGOPROVINCIA,v.ESTADOPROVINCIA,v.NOMBREPROVINCIA,v.IDPAIS FROM catalogoPais p join catalogoProvincia v on v.IDPAIS=p.IDPAIS where p.CODIGOPAIS=:codigoPais")
	List<Provincia> getProvinciasByCodigoPais(@Param("codigoPais") Long codigoPais);
	@Query(nativeQuery = true,value=
			"SELECT v.IDPROVINCIA, v.CODIGOPROVINCIA,v.ESTADOPROVINCIA,v.NOMBREPROVINCIA,v.IDPAIS FROM catalogoPais p join catalogoProvincia v on v.IDPAIS=p.IDPAIS where p.NACIONALIDAD=:nombrePais")
	List<Provincia> getProvinciasByNombrePais(@Param("nombrePais") String nombrePais);

}
