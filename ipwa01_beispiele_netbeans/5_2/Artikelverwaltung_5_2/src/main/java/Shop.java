import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Shop implements Serializable
{
  private List<Artikel> sortiment = new ArrayList<Artikel>();
  public Shop() {
    sortiment.add(new Artikel(1, "Pantoffeln \"Rudolph\"", 
            "Wunderschöne Filzpantoffeln", "filzschuhe.jpg"));
    sortiment.add(new Artikel(2, "Handtasche \"Cosmopolita\"", 
            "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung", 
            "handtasche.jpg"));
    sortiment.add(new Artikel(3, "Filz-Hasen \"Moe & Joe\"", 
            "Zwei putzige Hasen aus Filz zur Dekoration", "hasen.png"));
  }
  
  public List<Artikel> getSortiment() {
    return sortiment;
  }
}
