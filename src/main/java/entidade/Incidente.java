package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Incidente {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false, length = 20)
	private String tipoViolacao;
	@Column(nullable = false)
	private String providencias;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataEnvio;
	@Column(nullable = false)
	private Integer vitimaId;
	@Column(nullable = false)
	private Integer supostoAgressorId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoViolacao() {
		return tipoViolacao;
	}

	public void setTipoViolacao(String tipoViolacao) {
		this.tipoViolacao = tipoViolacao;
	}

	public String getProvidencias() {
		return providencias;
	}

	public void setProvidencias(String providencias) {
		this.providencias = providencias;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getVitimaId() {
		return vitimaId;
	}

	public void setVitimaId(Integer vitimaId) {
		this.vitimaId = vitimaId;
	}

	public Integer getSupostoAgressorId() {
		return supostoAgressorId;
	}

	public void setSupostoAgressorId(Integer supostoAgressorId) {
		this.supostoAgressorId = supostoAgressorId;
	}
}
