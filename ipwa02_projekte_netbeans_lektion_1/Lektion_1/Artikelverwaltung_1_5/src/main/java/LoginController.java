import java.io.Serializable;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable
{
  
    private Benutzer benutzer = new Benutzer();
    private String name;

    @Inject
    private Shop shop;
    
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
  
  public void postValidateName(ComponentSystemEvent ev)
    					throws AbortProcessingException
  {
    UIInput temp = (UIInput)ev.getComponent();
    this.name = (String)temp.getValue();
  }

  public void validateLogin(FacesContext context, UIComponent component,
                                Object value) throws ValidatorException
  {

    List<Benutzer> benutzerListe = shop.getBenutzer();
    for (Benutzer b : benutzerListe) {
      Benutzer temp = new Benutzer(this.name, (String) value);
      if (b.equals(temp))
        return;
    }
    throw new ValidatorException(new FacesMessage("Login falsch!"));
  }

  
  public String login() {
    return "index.xhtml";
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
