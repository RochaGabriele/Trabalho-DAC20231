package dao;

import static util.MessageUtil.errorMessage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entidade.Incidente;
import entidade.SupostoAgressor;
import entidade.Usuario;
import entidade.Vitima;
import util.JPAUtil;

public class UsuarioDao {
	public static void salvar(Usuario p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	public static void salvarEntidades(Vitima vitima, SupostoAgressor supostoAgressor, Incidente incidente) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(vitima);
		em.persist(supostoAgressor);
		em.persist(incidente);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Usuario p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Usuario> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select u from Usuario u order by u.id");
		List<Usuario> lista = q.getResultList();
		em.close();
		return lista;
	}

	public static Usuario selecionarUm(int id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select u from Usuario u WHERE u.id = :idUsuario", Usuario.class).setMaxResults(1);
		q.setParameter("idUsuario", id);
		Usuario usuario = (Usuario) q.getSingleResult();
		em.close();
		return usuario;
	}

	public static Usuario consultar(String login, String senha) {
		try {
			EntityManager em = JPAUtil.criarEntityManager();
			Query q = em
					.createQuery("select u from Usuario u WHERE u.login = :login and u.senha = :senha", Usuario.class)
					.setMaxResults(1);
			q.setParameter("login", login);
			q.setParameter("senha", senha);
			Usuario usuario = (Usuario) q.getSingleResult();
			em.close();
			return usuario;
		} catch (NoResultException e) {
			errorMessage("Erro", "Usuario invalido");
		} catch (Exception e) {
			errorMessage("Erro", "Contate o adminstrador do sistema.");
		}
		return null;
	}

	public static long contar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select count(u.id) from Usuario u");
		long quantidade = (long) q.getSingleResult();
		em.close();
		return quantidade;
	}

	public static void deletar(Usuario u) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		u = em.find(Usuario.class, u.getId());
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}
}
