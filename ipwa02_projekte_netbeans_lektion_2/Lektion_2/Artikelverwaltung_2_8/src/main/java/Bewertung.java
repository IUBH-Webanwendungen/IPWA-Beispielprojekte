import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bewertung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private byte sterne;
	private String kommentar;

	@ManyToOne
	private Artikel artikel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getSterne() {
		return sterne;
	}

	public void setSterne(byte sterne) {
		this.sterne = sterne;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	
}
