import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Shop
{
    private final static Shop instance = new Shop();

    private final ArtikelDAO artikelDao;

    public Shop()
    {
        artikelDao = new ArtikelDAO();
    }

    public static Shop getInstance()
    {
        return instance;
    }

    public List<Artikel> getSortiment()
    {
        return artikelDao.findAll();
    }

    void saveArticle(Artikel neuerArtikel)
    {
        artikelDao.save(neuerArtikel);
    }

    public void saveRatingForArticle(Bewertung bewertung, Artikel artikel)
    {
        artikelDao.saveRatingForArticle(bewertung, artikel);
    }

    public void deleteRatingForArticle(Bewertung bewertung, Artikel artikel)
    {
        artikelDao.deleteRatingForArticle(bewertung, artikel);
    }
}
