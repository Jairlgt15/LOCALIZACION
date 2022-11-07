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
@Table(name = "CatalogoCanton")
public class Canton {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCANTON")
	private Long idCanton;
	@ManyToOne(targetEntity = Provincia.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPROVINCIA",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Provincia idProvincia;
	@Column(name = "NOMBRECANTON")
	private String nombreCanton;
	@Column(name = "ESTADOCANTON")
	private boolean estadoCanton;
	
	public Canton() {
		super();
	}
	public Canton(Provincia idProvincia, String nombreCanton, boolean estadoCanton) {
		super();
		this.idProvincia = idProvincia;
		this.nombreCanton = nombreCanton;
		this.estadoCanton = estadoCanton;
	}
	public Canton(Long idCanton, Provincia idProvincia, String nombreCanton, boolean estadoCanton) {
		super();
		this.idCanton = idCanton;
		this.idProvincia = idProvincia;
		this.nombreCanton = nombreCanton;
		this.estadoCanton = estadoCanton;
	}
	public Long getIdCanton() {
		return idCanton;
	}
	public void setIdCanton(Long idCanton) {
		this.idCanton = idCanton;
	}
	public Provincia getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Provincia idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombreCanton() {
		return nombreCanton;
	}
	public void setNombreCanton(String nombreCanton) {
		this.nombreCanton = nombreCanton;
	}
	public boolean isEstadoCanton() {
		return estadoCanton;
	}
	public void setEstadoCanton(boolean estadoCanton) {
		this.estadoCanton = estadoCanton;
	}
	@Override
	public String toString() {
		return "Canton [idCanton=" + idCanton + ", idProvincia=" + idProvincia + ", nombreCanton=" + nombreCanton
				+ ", estadoCanton=" + estadoCanton + "]";
	}
}
