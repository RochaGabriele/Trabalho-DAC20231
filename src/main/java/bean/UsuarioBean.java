package bean;

import static util.MessageUtil.*;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.UsuarioDao;
import entidade.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
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
	
	public String deletar() {
		UsuarioDao.deletar(usuario);
		infoMessage("Sucesso", "Usuario removido com sucesso.");
		lista = UsuarioDao.listar();
		return null;
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
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}
	
	public String logar(String login, String senha) {
		usuario = UsuarioDao.consultar(login, senha);
		if(usuario == null) 
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
