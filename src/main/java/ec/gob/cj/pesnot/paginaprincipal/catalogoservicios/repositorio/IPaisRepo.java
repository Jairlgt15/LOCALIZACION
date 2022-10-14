package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Pais;

@Repository
public interface IPaisRepo  extends JpaRepository<Pais,Long> {
	
	
	@Query(nativeQuery = true,value="SELECT * FROM pais p WHERE p.NACIONALIDAD LIKE :nombre%")
	List<Pais> getPaisesLikeNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM pais where ESTADONACIONALIDAD='true'")
	List<Pais> getPaisesActivos();
	@Query(nativeQuery = true,value="SELECT * from pais where CODIGOPAIS = :codigoPais")
	Pais getNombrePaisByCodigo(@Param("codigoPais") String codigoPais);
	
	

}
