package bean;

import static util.MessageUtil.errorMessage;
import static util.MessageUtil.infoMessage;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.IncidenteDao;
import entidade.Incidente;

@ManagedBean
public class IncidenteBean {
	private Incidente incidente = new Incidente();
	private List<Incidente> lista;
	private long quantidade;

	public String salvar() {
		try {
			incidente.setDataEnvio(new Date());
			IncidenteDao.salvar(incidente);
			infoMessage("Sucesso", "Incidente salvo com sucesso.");
			incidente = new Incidente();
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}

	public String deletar() {
		IncidenteDao.deletar(incidente);
		infoMessage("Sucesso", "Incidente removido com sucesso.");
		lista = IncidenteDao.listar();
		return null;
	}

	public String editar(Incidente m) {
		try {
			incidente.setId(m.getId());
			incidente.setDescricao(m.getDescricao());
			incidente.setTipoViolacao(m.getTipoViolacao());
			incidente.setProvidencias(m.getProvidencias());
			incidente.setVitimaId(m.getVitimaId());
			incidente.setSupostoAgressorId(m.getSupostoAgressorId());

			IncidenteDao.editar(incidente);
			infoMessage("Sucesso", "Incidente editado com sucesso.");
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}

	public String selecionarIncidente() {
		incidente = IncidenteDao.selecionarUm(incidente.getId());
		return "detalhes_incidente.xhtml";
	}

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public List<Incidente> getLista() {
		if (lista == null) {
			lista = IncidenteDao.listar();
		}
		return lista;
	}

	public void setLista(List<Incidente> lista) {
		this.lista = lista;
	}

	public long getQuantidade() {
		quantidade = IncidenteDao.contar();
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

}
