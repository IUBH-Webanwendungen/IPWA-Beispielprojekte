
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class ArtikelDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlineshop");

	public List<Artikel> findAll() {
		EntityManager entityManager = emf.createEntityManager();
		Query abfrage = entityManager.createQuery("select a from Artikel a");
		List<Artikel> alleArtikel = abfrage.getResultList();
		entityManager.close();
		return alleArtikel;
	}
}
