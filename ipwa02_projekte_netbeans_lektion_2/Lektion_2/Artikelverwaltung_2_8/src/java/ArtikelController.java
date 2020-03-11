import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped

public class ArtikelController {
  
	private Artikel artikel = null;
	private Bewertung bewertung = null;
  
	public int getAnzahlArtikel() {
		return Shop.getInstance().getSortiment().size();
	}
	
  public List<Artikel> getSortiment() {
    return Shop.getInstance().getSortiment();
  }
	

	public void postValidateStuff(ComponentSystemEvent ev) throws AbortProcessingException {
		System.out.println("----------------> postValidateStuff!");
		UIComponent comp = ev.getComponent();
		comp.getAttributes().put("styleClass", "ui-input-valid");
	}
	
	public Artikel getArtikel() {
		return this.artikel;
		//return Shop.getInstance().getArtikel(artikel);
	}

	public Bewertung getBewertung() {
		if(null == this.bewertung) {
			this.bewertung = new Bewertung();
		}
		return this.bewertung;
	}

	public String saveRating() {
		Shop.getInstance().saveRatingForArticle(this.bewertung, this.artikel);
		this.bewertung = null;
		return "article";
	}

	public String article(Artikel artikel) {
		this.artikel = artikel;
		return "article";
	}
  
  public String edit(Artikel artikel) {
		this.artikel = artikel; 
		return "edit";
	}

	public String add() {
		this.artikel = new Artikel();
	Artikel art = new Artikel();
		return "edit";
	}
	
	public String remove(Artikel artikel) {
		return "index";
	}
	
	public String saveEdit() {
		Shop.getInstance().saveArticle(this.artikel);
		//return "index";
		return "";

	}

	public String cancelEdit() {
		this.artikel = null;
		return "index";
	}

	public String delete(Bewertung bewertung) {
		Shop.getInstance().delete(bewertung);
		return "edit";
	}
}
