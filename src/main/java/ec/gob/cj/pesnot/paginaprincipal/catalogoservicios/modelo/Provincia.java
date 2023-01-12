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
@Table(name = "CatalogoProvincia")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvincia")
	private Long idProvincia;
	@ManyToOne(targetEntity = Pais.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPais",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Pais idPais;
    @Column(name = "codigoProvincia")
	private int codigoProvincia;
	@Column(name = "nombreProvincia")
	private String nombreProvincia;
	@Column(name = "estadoProvincia")
	private boolean estadoProvincia;
	
	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provincia(Long idProvincia, Pais idPais, int codigoProvincia, String nombreProvincia,
			boolean estadoProvincia) {
		super();
		this.idProvincia = idProvincia;
		this.idPais = idPais;
		this.codigoProvincia = codigoProvincia;
		this.nombreProvincia = nombreProvincia;
		this.estadoProvincia = estadoProvincia;
	}
	public Provincia(Pais idPais, int codigoProvincia, String nombreProvincia, boolean estadoProvincia) {
		super();
		this.idPais = idPais;
		this.codigoProvincia = codigoProvincia;
		this.nombreProvincia = nombreProvincia;
		this.estadoProvincia = estadoProvincia;
	}
	public Long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public Pais getIdPais() {
		return idPais;
	}
	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
	}
	public int getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public boolean isEstadoProvincia() {
		return estadoProvincia;
	}
	public void setEstadoProvincia(boolean estadoProvincia) {
		this.estadoProvincia = estadoProvincia;
	}
	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", idPais=" + idPais + ", codigoProvincia=" + codigoProvincia
				+ ", nombreProvincia=" + nombreProvincia + ", estadoProvincia=" + estadoProvincia + "]";
	}

	
}
