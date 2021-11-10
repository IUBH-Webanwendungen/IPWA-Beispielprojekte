import java.io.Serializable;
import java.util.List;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable
{

  @Inject
  private Shop shop;

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
    List<Benutzer> benutzerListe = shop.getBenutzer();
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
