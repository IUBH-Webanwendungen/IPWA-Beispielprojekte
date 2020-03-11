
import javax.persistence.Entity;

@Entity
public class Film extends Artikel {

	private String trailer;

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

}
