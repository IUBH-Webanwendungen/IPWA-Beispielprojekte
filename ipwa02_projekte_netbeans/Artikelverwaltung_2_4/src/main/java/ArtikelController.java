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

    @Inject
    private Shop shop;

    private Artikel artikel;

    public Artikel getArtikel()
    {
		if (artikel == null) {
			artikel = shop.getSortiment().get(index);
		}
        return artikel;
    }

    public void vor()
    {
		if (index < shop.getSortiment().size() - 1) {
			index++;
		}
        artikel = null;
    }

    public void zurueck()
    {
		if (index > 0) {
			index--;
		}
        artikel = null;
    }

    public int getIndex()
    {
        return index;
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
}
