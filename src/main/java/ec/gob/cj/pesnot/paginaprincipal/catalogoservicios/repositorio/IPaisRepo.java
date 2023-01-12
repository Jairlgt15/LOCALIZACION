package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;

@Repository
public interface IPaisRepo  extends JpaRepository<Pais,Long> {
	
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoPais p WHERE p.nombrePais LIKE :nombre%")
	List<Pais> getPaisesLikeNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM catalogoPais where estadoPais='true'")
	List<Pais> getPaisesActivos();
	//TODO no se implementa aún este query, para que solo devuelva el nombre 
	@Query(nativeQuery = true,value="SELECT top 1 * from catalogoPais where codigoPais = :codigoPais")
	<Optional>Pais getNombrePaisByCodigo(@Param("codigoPais") int codigoPais);
	
	

}
