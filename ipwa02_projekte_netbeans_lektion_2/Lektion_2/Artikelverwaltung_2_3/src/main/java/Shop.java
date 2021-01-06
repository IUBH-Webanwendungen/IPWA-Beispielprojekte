/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author marian.benner
 */
@ManagedBean()
@ApplicationScoped
public class Shop
{
    private static Shop instance;

    private List<Artikel> sortiment = new ArrayList<Artikel>();

    private EntityManagerFactory entityManagerFactory;

    public Shop()
    {
        instance = this;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("onlineshop");
        } catch (Exception e) {
            throw new IllegalStateException("Can't create database connection.", e);
        }
    }

    public static Shop getInstance()
    {
        if ( instance == null ) instance = new Shop();
        return instance;
    }

    public List<Artikel> getSortiment()
    {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query q = em.createQuery("select a from Artikel a");
            List<Artikel> artikeln = q.getResultList();
            if(artikeln.size()==0) {
                System.err.println("Initting Artikel-Kollektion.");
                artikeln = basisAritkelKollektion();
                for(Artikel a: artikeln)
                    em.persist(a);
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

    private List<Artikel> basisAritkelKollektion() {
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
