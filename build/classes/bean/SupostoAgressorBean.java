package bean;

import static util.MessageUtil.errorMessage;
import static util.MessageUtil.infoMessage;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.SupostoAgressorDao;
import entidade.SupostoAgressor;

@ManagedBean
public class SupostoAgressorBean {
	private SupostoAgressor supostoAgressor = new SupostoAgressor();
	private List<SupostoAgressor> lista;
	private long quantidade;

	public String salvar() {
		try {
			supostoAgressor.setDataCriacao(new Date());
			SupostoAgressorDao.salvar(supostoAgressor);
			infoMessage("Sucesso", "Suposto agressor salvo com sucesso.");
			supostoAgressor = new SupostoAgressor();
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}

	public String deletar() {
		SupostoAgressorDao.deletar(supostoAgressor);
		infoMessage("Sucesso", "Suposto agressor removido com sucesso.");
		lista = SupostoAgressorDao.listar();
		return null;
	}

	public String editar(SupostoAgressor m) {
		try {
			supostoAgressor.setId(m.getId());
			supostoAgressor.setNome(m.getNome());
			supostoAgressor.setSexo(m.getSexo());
			supostoAgressor.setIdade(m.getIdade());
			supostoAgressor.setRelacionamento(m.getRelacionamento());
			supostoAgressor.setOcupacao(m.getOcupacao());
			supostoAgressor.setRaca(m.getRaca());
			supostoAgressor.setGenero(m.getGenero());
			supostoAgressor.setOrientacaoSexual(m.getOrientacaoSexual());
			supostoAgressor.setEscolaridade(m.getEscolaridade());

			SupostoAgressorDao.editar(supostoAgressor);
			infoMessage("Sucesso", "Suposto agressor editado com sucesso.");
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}

	public SupostoAgressor getSupostoAgressor() {
		return supostoAgressor;
	}

	public void setSupostoAgressor(SupostoAgressor supostoAgressor) {
		this.supostoAgressor = supostoAgressor;
	}

	public List<SupostoAgressor> getLista() {
		if (lista == null) {
			lista = SupostoAgressorDao.listar();
		}
		return lista;
	}

	public void setLista(List<SupostoAgressor> lista) {
		this.lista = lista;
	}

	public long getQuantidade() {
		quantidade = SupostoAgressorDao.contar();
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

}
