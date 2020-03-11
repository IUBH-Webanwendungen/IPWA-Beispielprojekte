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
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("onlineshop");

	public Shop() { }

	public List<Artikel> getSortiment() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createQuery("select a from Artikel a order by nr");
		List<Artikel> artikel = q.getResultList();
		em.close();
		System.out.println("Got " + artikel.size() + " articles.");
		return artikel;
	}

	public static Shop getInstance() {
		return instance;
	}

	void saveArticle(Artikel neuerArtikel) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(neuerArtikel);
		t.commit();
		em.close();
	}

	public void saveRatingForArticle(Bewertung bewertung, Artikel artikel) {
		artikel.getBewertungen().add(bewertung);
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(bewertung);
		em.merge(artikel);
		t.commit();
		em.close();
	}

	void deleteRatingForArticle(Bewertung bewertung, Artikel artikel) {
		
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
			artikel = em.merge(artikel);
			bewertung = em.merge(bewertung);
		t.commit();

		artikel.getBewertungen().remove(bewertung);
		
		t.begin();
			artikel = em.merge(artikel);
			em.remove(bewertung);
		t.commit();
		
		em.close();
	}

}
