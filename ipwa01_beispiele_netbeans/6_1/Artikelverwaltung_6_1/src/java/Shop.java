/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
           
    sortiment.add(new Artikel(1, "Pantoffeln \"Rudolph\"", 
            "Wunderschöne Filzpantoffeln", "filzschuhe.jpg", (new GregorianCalendar(2012, 11, 23).getTime())));
    sortiment.add(new Artikel(2, "Handtasche \"Cosmopolita\"", 
            "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung", 
            "handtasche.jpg", (new GregorianCalendar(2010, 10, 3).getTime())));
    sortiment.add(new Artikel(3, "Filz-Hasen \"Moe & Joe\"", 
            "Zwei putzige Hasen aus Filz zur Dekoration", "hasen.png", (new GregorianCalendar(2013, 11, 31).getTime())));
  }
  
  public List<Artikel> getSortiment() {
    return sortiment;
  }
  
  public static Shop getInstance(){
      return instance;
  }
}
