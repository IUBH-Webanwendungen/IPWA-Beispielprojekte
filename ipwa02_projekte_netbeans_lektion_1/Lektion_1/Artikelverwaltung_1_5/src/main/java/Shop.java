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

    private List<Benutzer> benutzer = new ArrayList<Benutzer>();

    public Shop()
    {
        sortiment.add(new Artikel(1001, "4034567890121", "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln", "filzschuhe.jpg", new Date(), 29.90));
        sortiment.add(new Artikel(1002, "4034567890121", "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung",
                "handtasche.jpg", new Date(), 49.90));
        sortiment.add(new Artikel(1003, "4034567890121", "Filz-Hasen \"Moe & Joe\"",
                "Zwei putzige Hasen aus Filz zur Dekoration", "hasen.png", new Date(), 19.90));
        benutzer.add(new Benutzer("koch", "123"));
        benutzer.add(new Benutzer("zander", "123"));
    }

    public List<Artikel> getSortiment()
    {
        return sortiment;
    }

    public List<Benutzer> getBenutzer()
    {
        return benutzer;
    }
}
