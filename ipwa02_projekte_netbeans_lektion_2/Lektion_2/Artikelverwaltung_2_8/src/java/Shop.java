/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author marian.benner
 */
@ManagedBean()
@ApplicationScoped
public class Shop {

	private List<Artikel> sortiment = new ArrayList<Artikel>();
	private static Shop instance = new Shop();
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlineshop");

	public Shop() {
	}

	public List<Artikel> getSortiment() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select a from Artikel a");
		List<Artikel> artikel = q.getResultList();
		return artikel;
	}

	public static Shop getInstance() {
		return instance;
	}

	void saveArticle(Artikel artikel) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(artikel);
		//em.persist(artikel);
		t.commit();
	}

	public Artikel getArtikel(Artikel artikel) {
		EntityManager em = emf.createEntityManager();
		return em.merge(artikel);
		//em.refresh(a);
	}

	public void saveRatingForArticle(Bewertung bewertung, Artikel artikel) {
		artikel.getBewertungen().add(bewertung);
		bewertung.setArtikel(artikel);
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(bewertung);
		em.merge(artikel);
		t.commit();
	}

	public List<Film> getFilme() {
		EntityManager em = emf.createEntityManager();

		return null;
	}

	public void delete(Bewertung bewertung) {
		Artikel a = new Artikel();
		a.setName("Hello ");

		bewertung.getArtikel().getBewertungen().remove(bewertung);
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
			bewertung = em.merge(bewertung);
			em.merge(bewertung.getArtikel());
			em.remove(bewertung);
			a = em.find(Artikel.class, 12);
		t.commit();
		em.close();
	}
}
