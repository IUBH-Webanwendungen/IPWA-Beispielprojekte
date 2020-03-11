import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ArtikelController {

  private int index = 0;
	private Artikel neuerArtikel = null;
  
  public Artikel getArtikel() {
    return Shop.getInstance().getSortiment().get(index);
  }
  
  public void vor(){
    if (index < Shop.getInstance().getSortiment().size()-1)
      index++;
  }
  
  public void zurueck(){
    if (index > 0)
      index--;
  }

  public int getIndex() {
    return index;
  }

	public Artikel getNeuerArtikel() {
		if(null == neuerArtikel) {
			this.neuerArtikel = new Artikel();
		}
		return this.neuerArtikel;
	}
  
	public String add() {
		return "edit";
	}

	public String abbrechen() {
		return "index";
	}
	
  
	public String speichern() {
		Shop.getInstance().saveArticle(neuerArtikel);
		return null;
	}
}
