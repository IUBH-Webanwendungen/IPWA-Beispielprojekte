
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ArtikelDAO {

	private EntityManagerFactory entityManagerFactory
					= Persistence.createEntityManagerFactory("onlineshop");

	public List<Artikel> findAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query abfrage = entityManager.createQuery("select a from Artikel a");
		List<Artikel> alleArtikel = abfrage.getResultList();
		entityManager.close();
		return alleArtikel;
	}

	void saveRatingForArticle(Bewertung bewertung, Artikel artikel) {
		artikel.getBewertungen().add(bewertung);
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(bewertung);
		em.merge(artikel);
		t.commit();
		em.close();
	}

	public void deleteRatingForArticle(Bewertung bewertung, Artikel artikel) {

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

	void save(Artikel neuerArtikel) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(neuerArtikel);
		t.commit();
		em.close();
	}
}
