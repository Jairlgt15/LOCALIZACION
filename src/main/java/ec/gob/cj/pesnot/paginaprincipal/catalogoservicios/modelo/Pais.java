package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogoPais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPAIS")
	private Long idPais;
    @Column(name = "CODIGOPAIS")
	private Long codigoPais;
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	@Column(name = "ESTADONACIONALIDAD")
	private boolean estadoNacionalidad;

	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pais(Long idPais, Long codigoPais, String nacionalidad, boolean estadoNacionalidad) {
		super();
		this.idPais = idPais;
		this.codigoPais = codigoPais;
		this.nacionalidad = nacionalidad;
		this.estadoNacionalidad = estadoNacionalidad;
	}
	public Pais(Long codigoPais, String nacionalidad, boolean estadoNacionalidad) {
		super();
		this.codigoPais = codigoPais;
		this.nacionalidad = nacionalidad;
		this.estadoNacionalidad = estadoNacionalidad;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	public Long getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public boolean isEstadoNacionalidad() {
		return estadoNacionalidad;
	}
	public void setEstadoNacionalidad(boolean estadoNacionalidad) {
		this.estadoNacionalidad = estadoNacionalidad;
	}
	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", codigoPais=" + codigoPais + ", nacionalidad=" + nacionalidad
				+ ", estadoNacionalidad=" + estadoNacionalidad + "]";
	}
}
