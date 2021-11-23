import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{
    private int index = 0;

    private Artikel neuerArtikel = null;

    private Artikel aktuellerArtikel = null;

    private Bewertung neueBewertung = null;

    @Inject
    private Shop shop;

    public Artikel getArtikel()
    {
		if (aktuellerArtikel == null) {
			aktuellerArtikel = shop.getSortiment().get(index);
		}
        return aktuellerArtikel;
    }

    public void vor()
    {
		if (index < shop.getSortiment().size() - 1) {
			index++;
		}
        aktuellerArtikel = null;
    }

    public void zurueck()
    {
		if (index > 0) {
			index--;
		}
        aktuellerArtikel = null;
    }

    public int getIndex()
    {
        return index;
    }

    public Bewertung getNeueBewertung()
    {
        if (null == this.neueBewertung) {
            this.neueBewertung = new Bewertung();
        }
        return this.neueBewertung;
    }

    public Artikel getNeuerArtikel()
    {
        if (null == neuerArtikel) {
            this.neuerArtikel = new Artikel();
        }
        return this.neuerArtikel;
    }

    public String add()
    {
        return "edit";
    }

    public String abbrechen()
    {
        return "index";
    }

    public String speichern()
    {
        shop.saveArticle(neuerArtikel);
        return null;
    }

    public String bewertungSpeichern()
    {
        shop.saveRatingForArticle(neueBewertung, getArtikel());
        this.aktuellerArtikel = null;
        this.neueBewertung = null;
        return "";
    }

    public String entferneBewertung(Bewertung bewertung)
    {
        shop.deleteRatingForArticle(bewertung, getArtikel());
        this.aktuellerArtikel = null;
        return "";
    }
}
