package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidade.SupostoAgressor;
import util.JPAUtil;

public class SupostoAgressorDao {
	public static void salvar(SupostoAgressor p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(SupostoAgressor p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<SupostoAgressor> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select s from SupostoAgressor s order by s.id");
		List<SupostoAgressor> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static SupostoAgressor selecionarUm(int id){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select s from SupostoAgressor s WHERE s.id = :idSupostoAgressor",
				SupostoAgressor.class).setMaxResults(1);
		q.setParameter("idSupostoAgressor", id);
		SupostoAgressor supostoAgressor = (SupostoAgressor) q.getSingleResult();
		em.close();
		return supostoAgressor;
	}
	
	public static long contar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select count(s.id) from SupostoAgressor s");
		long quantidade = (long) q.getSingleResult();
		em.close();
		return quantidade;
	}

	public static void deletar(SupostoAgressor s) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		s = em.find(SupostoAgressor.class, s.getId());
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
}
