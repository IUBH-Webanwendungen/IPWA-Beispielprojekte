import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Named
@ApplicationScoped
public class Shop {

	private List<Artikel> sortiment = new ArrayList<Artikel>();
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlineshop");

	public Shop() {
	}

	public List<Artikel> getSortiment() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select a from Artikel a");
		List<Artikel> artikel = q.getResultList();
		return artikel;
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
		Query q = em.createQuery("select a from Film a");
		List<Film> filme = q.getResultList();
		return filme;
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
