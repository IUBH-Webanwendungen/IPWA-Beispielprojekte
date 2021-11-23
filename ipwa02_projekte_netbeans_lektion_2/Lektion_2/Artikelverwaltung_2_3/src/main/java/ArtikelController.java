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

    private Artikel artikel;

    public Artikel getArtikel()
    {
        if (artikel == null) {
            artikel = shop.getSortiment().get(index);
        }
        return artikel;
    }

    public void vor()
    {
        if (index < shop.getSortiment().size() - 1) {
            index++;
            artikel = null;
        }
    }

    public void zurueck()
    {
        if (index > 0) {
            index--;
            artikel = null;
        }
    }

    public int getIndex()
    {
        return index;
    }

    public String handleBildKeyEvent(AjaxBehaviorEvent input)
    {
        System.out.println("Input event! " + input);
        return "input";
    }
}
