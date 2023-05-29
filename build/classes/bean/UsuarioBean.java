package bean;

import static util.MessageUtil.errorMessage;
import static util.MessageUtil.infoMessage;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.IncidenteDao;
import dao.SupostoAgressorDao;
import dao.UsuarioDao;
import dao.VitimaDao;
import entidade.Incidente;
import entidade.SupostoAgressor;
import entidade.Usuario;
import entidade.Vitima;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Vitima vitima = new Vitima();
	private Incidente incidente = new Incidente();
	private SupostoAgressor supostoAgressor = new SupostoAgressor();
	private List<Usuario> lista;
	private long quantidade;

	public String salvar() {
		try {
			usuario.setDataDeCadastro(new Date());
			UsuarioDao.salvar(usuario);
			infoMessage("Sucesso", "Usuario salvo com sucesso.");
			usuario = new Usuario();
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}

	public void salvarEntidades() {
		try {
			vitima.setDataCriacao(new Date());
			VitimaDao.salvar(vitima);
			supostoAgressor.setDataCriacao(new Date());
			SupostoAgressorDao.salvar(supostoAgressor);
			incidente.setDataEnvio(new Date());
			incidente.setSupostoAgressorId(supostoAgressor.getId());
			incidente.setVitimaId(vitima.getId());
			IncidenteDao.salvar(incidente);
			infoMessage("Sucesso", "Formulário registrado com sucesso.");
			vitima = new Vitima();
			supostoAgressor = new SupostoAgressor();
			incidente = new Incidente();
		} catch (Exception e) {
			errorMessage("Erro", e.getMessage());
		}
	}

	public String deletar() {
		UsuarioDao.deletar(usuario);
		infoMessage("Sucesso", "Usuario removido com sucesso.");
		lista = UsuarioDao.listar();
		return null;
	}

	public String editar() {
		usuario = UsuarioDao.selecionarUm(usuario.getId());
		return "editar_usuario.xhtml";
	}

	public Usuario selecionarUsuario() {
		usuario = UsuarioDao.selecionarUm(usuario.getId());
		return usuario;
	}

	public String editar(Usuario m) {
		try {
			usuario.setId(m.getId());
			usuario.setNome(m.getNome());
			usuario.setLogin(m.getLogin());
			usuario.setSenha(m.getSenha());

			UsuarioDao.editar(usuario);
			infoMessage("Sucesso", "Usuario editado com sucesso.");
		} catch (Exception e) {
			errorMessage("Erro", e.getMessage());
		}
		return null;
	}

	public String logar(String login, String senha) {
		usuario = UsuarioDao.consultar(login, senha);
		if (usuario == null)
			return null;
		else
			return "listagem_incidente.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vitima getVitima() {
		return vitima;
	}

	public void setVitima(Vitima vitima) {
		this.vitima = vitima;
	}

	public SupostoAgressor getSupostoAgressor() {
		return supostoAgressor;
	}

	public void setSupostoAgressor(SupostoAgressor supostoAgressor) {
		this.supostoAgressor = supostoAgressor;
	}

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public List<Usuario> getLista() {
		if (lista == null) {
			lista = UsuarioDao.listar();
		}
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public long getQuantidade() {
		quantidade = UsuarioDao.contar();
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

}
