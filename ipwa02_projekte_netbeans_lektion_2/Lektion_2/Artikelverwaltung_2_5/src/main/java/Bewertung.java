import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bewertung implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private byte sterne;

    private String kommentar;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public byte getSterne()
    {
        return sterne;
    }

    public void setSterne(byte sterne)
    {
        this.sterne = sterne;
    }

    public String getKommentar()
    {
        return kommentar;
    }

    public void setKommentar(String kommentar)
    {
        this.kommentar = kommentar;
    }
}
