import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ArtikelController implements Serializable
{
    private Artikel artikel = null;

    private Bewertung bewertung = null;

    @Inject
    private Shop shop;

    public int getAnzahlArtikel()
    {
        return shop.getSortiment().size();
    }

    public List<Artikel> getSortiment()
    {
        return shop.getSortiment();
    }

    public void postValidateStuff(ComponentSystemEvent ev) throws AbortProcessingException
    {
        System.out.println("----------------> postValidateStuff!");
        UIComponent comp = ev.getComponent();
        comp.getAttributes().put("styleClass", "ui-input-valid");
    }

    public Artikel getArtikel()
    {
        return this.artikel;
        //return shop.getArtikel(artikel);
    }

    public Artikel getNeuerArtikel()
    {
        this.artikel = new Artikel();
        return this.artikel;
    }

    public List<Film> getFilme()
    {
        return shop.getFilme();
    }

    public Bewertung getBewertung()
    {
        if (null == this.bewertung) {
            this.bewertung = new Bewertung();
        }
        return this.bewertung;
    }

    public String saveRating()
    {
        shop.saveRatingForArticle(this.bewertung, this.artikel);
        this.bewertung = null;
        return "article";
    }

    public String article(Artikel artikel)
    {
        this.artikel = artikel;
        return "article";
    }

    public String edit(Artikel artikel)
    {
        this.artikel = artikel;
        return "edit";
    }

    public String add()
    {
        this.artikel = new Artikel();
        Artikel art = new Artikel();
        return "edit";
    }

    public String remove(Artikel artikel)
    {
        return "index";
    }

    public String saveEdit()
    {
        shop.saveArticle(this.artikel);
        //return "index";
        return "";
    }

    public String cancelEdit()
    {
        this.artikel = null;
        return "index";
    }

    public String delete(Bewertung bewertung)
    {
        shop.delete(bewertung);
        return "edit";
    }
}
