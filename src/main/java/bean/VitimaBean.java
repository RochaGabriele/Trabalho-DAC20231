package bean;

import static util.MessageUtil.errorMessage;
import static util.MessageUtil.infoMessage;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.VitimaDao;
import entidade.Vitima;

@ManagedBean
public class VitimaBean {
	private Vitima vitima = new Vitima();
	private List<Vitima> lista;
	private long quantidade;

	public String salvar() {
		try {
			vitima.setDataCriacao(new Date());
			VitimaDao.salvar(vitima);
			infoMessage("Sucesso", "Vitima salva com sucesso.");
			vitima = new Vitima();
		} catch (Exception e) {
			errorMessage("Erro", e.getMessage());
		}
		return null;
	}

	public String deletar() {
		VitimaDao.deletar(vitima);
		infoMessage("Sucesso", "Vítima removida com sucesso.");
		lista = VitimaDao.listar();
		return null;
	}

	public String editar(Vitima m) {
		try {
			vitima.setId(m.getId());
			vitima.setNome(m.getNome());
			vitima.setSexo(m.getSexo());
			vitima.setIdade(m.getIdade());
			vitima.setSerie_turno(m.getSerie_turno());
			vitima.setEndereço(m.getEndereço());

			VitimaDao.editar(vitima);
			infoMessage("Sucesso", "Vitima editada com sucesso.");
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}
	
	public Vitima getVitima() {
		return vitima;
	}

	public void setVitima(Vitima vitima) {
		this.vitima = vitima;
	}

	public List<Vitima> getLista() {
		if (lista == null) {
			lista = VitimaDao.listar();
		}
		return lista;
	}

	public void setLista(List<Vitima> lista) {
		this.lista = lista;
	}

	public long getQuantidade() {
		quantidade = VitimaDao.contar();
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

}
