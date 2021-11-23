import java.io.Serializable;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{
    private int index = 0;

    public void validateGTIN(FacesContext context, UIComponent component, Object value)
            throws ValidatorException
    {
        String id = (String) value;
        int cipher = Artikel.berechnePruefsumme(id);
        if (!id.endsWith(String.valueOf(cipher))) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Fehlerhafte GTIN",
                    id + " ist eine " + "fehlerhafte GTIN (erwartete Prüfziffer: " + cipher + ")")
            );
        }
    }

    public Artikel getArtikel()
    {
        return Shop.getInstance().getSortiment().get(index);
    }

    public void vor()
    {
      if (index < Shop.getInstance().getSortiment().size() - 1) {
        index++;
      }
    }

    public void zurueck()
    {
      if (index > 0) {
        index--;
      }
    }

    public int getIndex()
    {
        return index;
    }
}
