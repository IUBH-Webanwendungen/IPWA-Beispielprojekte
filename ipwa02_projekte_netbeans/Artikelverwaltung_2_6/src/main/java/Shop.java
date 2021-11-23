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
public class Shop
{
    private List<Artikel> sortiment = new ArrayList<Artikel>();

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("onlineshop");

    public Shop()
    {
    }

    public List<Artikel> getSortiment()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query q = em.createQuery("select a from Artikel a order by nr");
        List<Artikel> artikel = q.getResultList();
        em.close();
        System.out.println("Got " + artikel.size() + " articles.");
        return artikel;
    }

    void saveArticle(Artikel neuerArtikel)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(neuerArtikel);
        t.commit();
        em.close();
    }

    public void saveRatingForArticle(Bewertung bewertung, Artikel artikel)
    {
        artikel.getBewertungen().add(bewertung);
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(bewertung);
        em.merge(artikel);
        t.commit();
        em.close();
    }

    void deleteRatingForArticle(Bewertung bewertung, Artikel artikel)
    {

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
