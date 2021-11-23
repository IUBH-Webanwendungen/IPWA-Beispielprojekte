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
}
