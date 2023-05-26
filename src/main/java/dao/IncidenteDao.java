package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidade.Incidente;
import util.JPAUtil;

public class IncidenteDao {
	public static void salvar(Incidente p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Incidente p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Incidente> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select i from Incidente i order by i.id");
		List<Incidente> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static Incidente selecionarUm(int id){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select i from Incidente i WHERE i.id = :idIncidente",
				Incidente.class).setMaxResults(1);
		q.setParameter("idIncidente", id);
		Incidente incidente = (Incidente) q.getSingleResult();
		em.close();
		return incidente;
	}
	
	public static long contar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select count(i.id) from Incidente i");
		long quantidade = (long) q.getSingleResult();
		em.close();
		return quantidade;
	}

	public static void deletar(Incidente i) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		i = em.find(Incidente.class, i.getId());
		em.remove(i);
		em.getTransaction().commit();
		em.close();
	}
}
