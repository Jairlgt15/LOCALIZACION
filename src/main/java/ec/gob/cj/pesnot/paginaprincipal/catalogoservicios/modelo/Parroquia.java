package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "parroquia")
public class Parroquia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDPARROQUIA")
	private Long idParroquia;
	@ManyToOne(targetEntity = Canton.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCANTON",nullable=false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Canton idCanton;
	@Column(name = "NOMBREPARROQUIA")
	private String nombreParroquia;
	@Column(name = "ESTADOPARROQUIA")
	private boolean estadoParroquia;
	public Parroquia(Canton idCanton, String nombreParroquia, boolean estadoParroquia) {
		super();
		this.idCanton = idCanton;
		this.nombreParroquia = nombreParroquia;
		this.estadoParroquia = estadoParroquia;
	}
	public Parroquia(Long idParroquia, Canton idCanton, String nombreParroquia, boolean estadoParroquia) {
		super();
		this.idParroquia = idParroquia;
		this.idCanton = idCanton;
		this.nombreParroquia = nombreParroquia;
		this.estadoParroquia = estadoParroquia;
	}
	public Long getIdParroquia() {
		return idParroquia;
	}
	public void setIdParroquia(Long idParroquia) {
		this.idParroquia = idParroquia;
	}
	public Canton getIdCanton() {
		return idCanton;
	}
	public void setIdCanton(Canton idCanton) {
		this.idCanton = idCanton;
	}
	public String getNombreParroquia() {
		return nombreParroquia;
	}
	public void setNombreParroquia(String nombreParroquia) {
		this.nombreParroquia = nombreParroquia;
	}
	public boolean isEstadoParroquia() {
		return estadoParroquia;
	}
	public void setEstadoParroquia(boolean estadoParroquia) {
		this.estadoParroquia = estadoParroquia;
	}
	@Override
	public String toString() {
		return "Parroquia [idParroquia=" + idParroquia + ", idCanton=" + idCanton + ", nombreParroquia="
				+ nombreParroquia + ", estadoParroquia=" + estadoParroquia + "]";
	}
}
