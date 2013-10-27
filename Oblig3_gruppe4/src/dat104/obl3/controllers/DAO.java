package dat104.obl3.controllers;
import java.util.List;

import javax.persistence.*;

import dat104.obl3.models.Spill;
import dat104.obl3.models.Bruker;


public class DAO {
	static private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
	private EntityManager entityManager = null;
	private EntityTransaction entityTransaction = null;
	
	public DAO() {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	public void leggTil(Object nyttObjekt) {
		entityManager.persist(nyttObjekt);
	}
	
	public Spill getSpill(int id) {
		return entityManager.find(Spill.class, id);
	}
	
	public void Oppdater(Object endretObjekt) {
		entityManager.merge(endretObjekt);
	}
	
	public void slettSpill(int id){
		entityManager.remove(entityManager.find(Spill.class, id));
	}
	
	public void slettBruker(String brukernavn){
		entityManager.remove(entityManager.find(Bruker.class, brukernavn));
	}
	
	public void Lagre(boolean lukk) {
		entityTransaction.commit();
		if (lukk) 
			Lukk();
	}
	
	public Bruker HentValidertBruker(String brukernavn, String passord) {
		TypedQuery<Bruker> q = entityManager.createQuery("SELECT b from Bruker b WHERE b.brukernavn = :brukernavn AND b.passord = :passord",Bruker.class);
		q.setParameter("brukernavn", brukernavn);
		q.setParameter("passord", passord);
		List<Bruker> brukere = q.getResultList();
		if (brukere.size() == 1)
			return brukere.get(0);
		else
			return null;
	}
	
	public List<Spill> HentAktiveSpill() {
		TypedQuery<Spill> q = entityManager.createQuery("SELECT s from Spill s",Spill.class);
		return q.getResultList();
	}
	
	public void Tilbakestill(boolean lukk) {
		entityTransaction.rollback();
		if (lukk) 
			Lukk();
	}
	
	public void Lukk() {
		if (entityManager != null) {
			entityManager.close();
			entityTransaction = null;
			entityManager = null;
		}
	}
}
