import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class ArtikelController
{
    private int index = 0;

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

    public String handleBildKeyEvent(AjaxBehaviorEvent input) {
        return "input";
    }
}
