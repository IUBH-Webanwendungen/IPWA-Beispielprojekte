
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.validation.ValidationException;

/**
 *
 * @author Marian
 */
@ManagedBean
@ViewScoped
public class LoginController {
  
    private Benutzer benutzer = new Benutzer();

  /**
   * Get the value of benutzer
   *
   * @return the value of benutzer
   */
  public Benutzer getBenutzer() {
    return benutzer;
  }

  /**
   * Set the value of benutzer
   *
   * @param benutzer new value of benutzer
   */
  public void setBenutzer(Benutzer benutzer) {
    this.benutzer = benutzer;
  }

  public String login() {
  List<Benutzer> benutzerListe = Shop.getInstance().getBenutzer();
  for (Benutzer b : benutzerListe) {
    if (b.equals(this.benutzer))
      return "index.xhtml";
  }
  return "login.xhtml";
}

  
// etwas schöner ist die Trennung von check und Navigation: 
// private boolean checkLogin(){
//    List<Benutzer> benutzerListe = Shop.getInstance().getBenutzer();
//    for (Benutzer b : benutzerListe) {
//      if (b.equals(this.benutzer))
//        return true;
//    }
//    return false;
//  }
//  
//  public String login() {
//    if (checkLogin())
//      return "index.xhtml";
//    else
//      return "login.xhtml";
//  }
  
}
