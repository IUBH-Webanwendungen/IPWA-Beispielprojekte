import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Shop
{
    private static Shop instance = new Shop();

    private List<Artikel> sortiment = new ArrayList<Artikel>();

    public Shop()
    {
        sortiment.add(new Artikel(1001, "4034567890121", "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln", "filzschuhe.jpg", new Date()));
        sortiment.add(new Artikel(1002, "4034567890121", "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung",
                "handtasche.jpg", new Date()));
        sortiment.add(new Artikel(1003, "4034567890121", "Filz-Hasen \"Moe & Joe\"",
                "Zwei putzige Hasen aus Filz zur Dekoration", "hasen.png", new Date()));
    }

    public static Shop getInstance()
    {
        return instance;
    }

    public List<Artikel> getSortiment()
    {
        return sortiment;
    }
}
