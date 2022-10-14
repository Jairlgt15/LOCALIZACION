package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Provincia;

@Repository
public interface IProvinciaRepo  extends JpaRepository<Provincia,Long> {

}
