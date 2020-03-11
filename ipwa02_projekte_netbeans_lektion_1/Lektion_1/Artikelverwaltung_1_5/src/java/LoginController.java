
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Marian
 */
@ManagedBean
@ViewScoped
public class LoginController {
  
    private Benutzer benutzer = new Benutzer();
    private String name;
    
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
    					throws AbortProcessingException {
    UIInput temp = (UIInput)ev.getComponent();
    this.name = (String)temp.getValue();
  }

  public void validateLogin(FacesContext context, UIComponent component, 
                                Object value) throws ValidatorException {  

    List<Benutzer> benutzerListe = Shop.getInstance().getBenutzer();
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
