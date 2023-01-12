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
    @Column(name = "idPais")
	private Long idPais;
    @Column(name = "codigoPais")
	private int codigoPais;
	@Column(name = "nombrePais")
	private String nacionalidad;
	@Column(name = "estadoPais")
	private boolean estadoNacionalidad;

	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pais(Long idPais, int codigoPais, String nacionalidad, boolean estadoNacionalidad) {
		super();
		this.idPais = idPais;
		this.codigoPais = codigoPais;
		this.nacionalidad = nacionalidad;
		this.estadoNacionalidad = estadoNacionalidad;
	}
	public Pais(int codigoPais, String nacionalidad, boolean estadoNacionalidad) {
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
	public int getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(int codigoPais) {
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
