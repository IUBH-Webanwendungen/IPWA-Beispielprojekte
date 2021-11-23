import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{

  private int index = 0;
	private Artikel artikel = null;
	private Bewertung neueBewertung = null;

	@Inject
	private Shop shop;
  
  public Artikel getArtikel() {
    if(artikel == null)
     	artikel = shop.getSortiment().get(index);
    return artikel;
  }
  
  public void vor(){
    if (index < shop.getSortiment().size()-1)
      index++;
    artikel = null;
  }
  
  public void zurueck(){
    if (index > 0)
      index--;
    artikel = null;
  }

  public int getIndex() {
    return index;
  }

	public Bewertung getNeueBewertung() {
		if(null == this.neueBewertung) {
			this.neueBewertung = new Bewertung();
		}
		return this.neueBewertung;
	}
	public Artikel getNeuerArtikel() {
		if(null == artikel) {
			this.artikel = new Artikel();
		}
		return this.artikel;
	}
  
	public String add() {
		return "edit";
	}

	public String abbrechen() {
		return "index";
	}
	
  
	public String speichern() {
		shop.saveArticle(artikel);
		return null;
	}

	public String bewertungSpeichern() {
		shop.saveRatingForArticle(neueBewertung, getArtikel());
		this.neueBewertung = null;
		return "";
	}

	public String entferneBewertung(Bewertung bewertung) {
		shop.deleteRatingForArticle(bewertung, getArtikel());
		return "";
	}
}
