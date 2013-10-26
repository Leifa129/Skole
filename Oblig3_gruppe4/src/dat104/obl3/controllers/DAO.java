package dat104.obl3.controllers;
import javax.persistence.*;
import dat104.obl3.models.Spill;
import dat104.obl3.models.Bruker;


public class DAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");
	private EntityManager em = null;
	
	public void leggTil(Object nyttObjekt) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(nyttObjekt);
		em.getTransaction().commit();
		em.close();
	}
	
	public Spill getSpill(int id) {
		em = emf.createEntityManager();
		Spill spill = em.find(Spill.class, id);
		em.close();
		return spill;
	}
	
	public void oppdater(Object endretObjekt) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(endretObjekt);
		em.getTransaction().commit();
		em.close();
	}
	
	public void slettSpill(int id){
		em = emf.createEntityManager();
		 Spill spill = em.find(Spill.class, id);
		  em.getTransaction().begin();
		  em.remove(spill);
		  em.getTransaction().commit();
		  em.close();
	}
	
	public void slettBruker(String brukernavn){
		em = emf.createEntityManager();
		 Bruker bruker = em.find(Bruker.class, brukernavn);
		  em.getTransaction().begin();
		  em.remove(bruker);
		  em.getTransaction().commit();
		  em.close();
	}
	
	
	
	public void closeEntityMangerFactory() {
		emf.close();
	}
}
