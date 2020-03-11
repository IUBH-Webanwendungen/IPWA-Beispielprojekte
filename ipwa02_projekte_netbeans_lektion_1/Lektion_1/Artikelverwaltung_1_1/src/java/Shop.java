/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author marian.benner
 */
@ManagedBean()
@ApplicationScoped
public class Shop {
  private List<Artikel> sortiment = new ArrayList<Artikel>();
  private static Shop instance = new Shop();

  public Shop() {
    sortiment.add(new Artikel(1001, "4034567890121", "Pantoffeln \"Rudolph\"", 
            "Wunderschöne Filzpantoffeln", "filzschuhe.jpg", new Date()));
    sortiment.add(new Artikel(1002, "4034567890121", "Handtasche \"Cosmopolita\"", 
            "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung", 
            "handtasche.jpg", new Date()));
    sortiment.add(new Artikel(1003, "4034567890121", "Filz-Hasen \"Moe & Joe\"", 
            "Zwei putzige Hasen aus Filz zur Dekoration", "hasen.png", new Date()));
  }
  
  public List<Artikel> getSortiment() {
    return sortiment;
  }
  
  public static Shop getInstance(){
      return instance;
  }
}
