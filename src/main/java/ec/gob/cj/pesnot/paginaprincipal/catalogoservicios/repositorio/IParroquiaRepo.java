package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Parroquia;

@Repository
public interface IParroquiaRepo  extends JpaRepository<Parroquia,Long> {
	//aqui van los querys

}
