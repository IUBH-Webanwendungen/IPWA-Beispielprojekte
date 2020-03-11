
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Artikel {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
    private int nr;
    private String name;
    private String text;
    private String bild;
		@Temporal(TemporalType.DATE)
    private Date verfuegbarAb;

		@OneToMany(fetch = FetchType.EAGER)
		private List<Bewertung> bewertungen;

	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}

	public void setBewertungen(List<Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	}

    public Artikel() {
    }

    public Artikel(int nr, String name, String text, String bild) {
        this(nr, name, text, bild, new Date(0));
    }

    public Artikel(int nr, String name, String text, String bild, Date verfuegbarAb) {
        this.nr = nr;
        this.name = name;
        this.text = text;
        this.bild = bild;
        this.verfuegbarAb = verfuegbarAb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

		public void setNr(int nr) {
			this.nr = nr;
		}
		
    public int getNr() {
        return nr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public Date getVerfuegbarAb() {
        return verfuegbarAb;
    }

    public void setVerfuegbarAb(Date verfuegbarAb) {
        this.verfuegbarAb = verfuegbarAb;
    }



}
