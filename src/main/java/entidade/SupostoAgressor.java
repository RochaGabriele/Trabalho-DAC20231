package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SupostoAgressor {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 1)
	private String sexo;
	@Column(nullable = false)
	private int idade;
	@Column(nullable = false, length = 100)
	private String relacionamento;
	@Column(length = 100)
	private String ocupacao;
	@Column(length = 10)
	private String raca;
	@Column(length = 50)
	private String genero;
	@Column(length = 50)
	private String orientacaoSexual;
	@Column(length = 50)
	private String escolaridade;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCriacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getRelacionamento() {
		return relacionamento;
	}
	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getOrientacaoSexual() {
		return orientacaoSexual;
	}
	public void setOrientacaoSexual(String orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}