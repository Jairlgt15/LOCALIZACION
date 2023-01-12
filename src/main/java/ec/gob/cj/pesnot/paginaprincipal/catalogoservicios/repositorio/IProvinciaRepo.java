package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;

@Repository
public interface IProvinciaRepo  extends JpaRepository<Provincia,Long> {
	
	@Query(nativeQuery =true,value = "SELECT * FROM catalogoProvincia p where p.idPais = :idPais and p.estadoProvincia=1;")
	List<Provincia> getProvinciasByPais(@Param("idPais") String idPais);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoProvincia p WHERE p.nombreProvincia LIKE :nombre%")
	List<Provincia> getProvinciasLikeNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoProvincia where estadoProvincia='true'")
	List<Provincia> getProvinciasActivos();
	@Query(nativeQuery = true,value="SELECT * from catalogoProvincia where codigoProvincia = :codigoProvincia")
	List <Provincia> getNombreProvinciaByCodigo(@Param("codigoProvincia") int codigoProvincia);
	
	@Query(nativeQuery = true,value=
			"SELECT v.idProvincia, v.codigoProvincia,v.estadoProvincia,v.nombreProvincia,v.idPais FROM catalogoPais p join catalogoProvincia v on v.idPais=p.idPais where p.codigoPais=:codigoPais")
	List<Provincia> getProvinciasByCodigoPais(@Param("codigoPais") int codigoPais);
	@Query(nativeQuery = true,value=
			"SELECT v.IDPROVINCIA, v.codigoProvincia,v.estadoProvincia,v.nombreProvincia,v.idPais FROM catalogoPais p join catalogoProvincia v on v.idPais=p.idPais where p.nombrePais=:nombrePais")
	List<Provincia> getProvinciasByNombrePais(@Param("nombrePais") String nombrePais);

}
