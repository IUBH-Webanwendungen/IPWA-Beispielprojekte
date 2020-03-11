
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


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
