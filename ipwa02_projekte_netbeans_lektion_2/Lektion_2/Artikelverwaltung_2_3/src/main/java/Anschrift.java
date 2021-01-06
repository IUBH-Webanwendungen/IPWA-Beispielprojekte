/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author marian.benner
 */
@ManagedBean
@ApplicationScoped
public class Anschrift
{
    private String name = "Filzprodukte Zander GmbH";

    private String strasse = "Märkische Straße";

    private int hausnummer = 15;

    private String plz = "32805";

    private String ort = "Horn-Bad Meinberg";

    /**
     * Creates a new instance of Adresse
     */
    public Anschrift()
    {
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the strasse
     */
    public String getStrasse()
    {
        return strasse;
    }

    /**
     * @return the hausnummer
     */
    public int getHausnummer()
    {
        return hausnummer;
    }

    /**
     * @return the plz
     */
    public String getPlz()
    {
        return plz;
    }

    /**
     * @return the ort
     */
    public String getOrt()
    {
        return ort;
    }
}
