import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Film extends Artikel implements Serializable
{
    private String trailer;

    public String getTrailer()
    {
        return trailer;
    }

    public void setTrailer(String trailer)
    {
        this.trailer = trailer;
    }
}
