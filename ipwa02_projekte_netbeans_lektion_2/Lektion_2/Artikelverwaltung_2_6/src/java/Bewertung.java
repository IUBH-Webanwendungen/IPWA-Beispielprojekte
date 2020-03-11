import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bewertung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private byte sterne;
	private String kommentar;

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
	
}
