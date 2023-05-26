package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidade.Vitima;
import util.JPAUtil;

public class VitimaDao {
	public static void salvar(Vitima p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Vitima p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Vitima> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select v from Vitima v order by v.id");
		List<Vitima> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static Vitima selecionarUm(int id){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select v from Vitima v WHERE v.id = :idVitima",
				Vitima.class).setMaxResults(1);
		q.setParameter("idVitima", id);
		Vitima vitima = (Vitima) q.getSingleResult();
		em.close();
		return vitima;
	}
	
	public static long contar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select count(v.id) from Vitima v");
		long quantidade = (long) q.getSingleResult();
		em.close();
		return quantidade;
	}

	public static void deletar(Vitima v) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		v = em.find(Vitima.class, v.getId());
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
}
