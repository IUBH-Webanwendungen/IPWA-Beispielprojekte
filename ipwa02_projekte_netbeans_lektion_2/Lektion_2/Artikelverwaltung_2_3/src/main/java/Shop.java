import java.util.ArrayList;
import java.util.LinkedList;
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

    private EntityManagerFactory entityManagerFactory;

    public Shop()
    {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("onlineshop");
        } catch (Exception e) {
            throw new IllegalStateException("Can't create database connection.", e);
        }
    }

    public List<Artikel> getSortiment()
    {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query q = em.createQuery("select a from Artikel a");
            List<Artikel> artikeln = q.getResultList();
            if (artikeln.size() == 0) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                System.err.println("Initting Artikel-Kollektion.");
                artikeln = basisAritkelKollektion();
                for (Artikel a : artikeln) {
                    em.persist(a);
                }
                transaction.commit();
            }
            em.close();

            System.out.println("Got " + artikeln.size() + " articles.");
            return artikeln;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Running on fallback Artikel-Kollektion.");
            return basisAritkelKollektion();
        }
    }

    private List<Artikel> basisAritkelKollektion()
    {
        List<Artikel> list = new LinkedList<>();
        list.add(new Artikel(1, "Filzschuhe schick", "Schicke Armani-branded Filzschuhen",
                "filzschuhe.jpg"));
        list.add(new Artikel(2, "Handtasche schick", "Schicke Moschino-branded Handtasche",
                "handtasche.jpg"));
        list.add(new Artikel(3, "Süsse Hasenpaar", "Süsse Hasenpaar",
                "hasen.png"));
        return list;
    }
}
