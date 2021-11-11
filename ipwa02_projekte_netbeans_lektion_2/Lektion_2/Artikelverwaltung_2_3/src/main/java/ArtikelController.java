import java.io.Serializable;

import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{
    private int index = 0;

    @Inject
    private Shop shop;

    public Artikel getArtikel()
    {
        return shop.getSortiment().get(index);
    }

    public void vor()
    {
      if (index < shop.getSortiment().size() - 1) {
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

    public String handleBildKeyEvent(AjaxBehaviorEvent input) {
        return "input";
    }
}
