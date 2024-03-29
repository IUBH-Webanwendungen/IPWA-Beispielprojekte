
import java.math.BigDecimal;
import java.util.Date;

public class Artikel {
  
  public static int berechnePruefsumme(String gtin) {
    if (gtin.length() != 13)
      return -1;
    
    int sum = 0;
    int even_factor = 1;
    int odd_factor = 3;
    
    for (int i=0; i<12; i++)
    {
      int value = gtin.charAt(i) - '0';
      if (i%2==0) // even
        sum += even_factor * value;
      else      // odd
        sum += odd_factor * value;
    }
    int ceil = (int) Math.ceil(sum/10d)*10;
    
    return Math.abs(sum-ceil);
  }

  private int nr;
  private String name;
  private String text;
  private String bild;
  private Date erstelldatum;
  private String gtin;
  private double preis;
          
  public Artikel(){
  }

  public Artikel(int nr, String gtin, String name, String text, String bild, Date erstellt_am, double preis) {
    this.nr = nr;
    this.gtin = gtin;
    this.name = name;
    this.text = text;
    this.bild = bild;
    this.erstelldatum = erstellt_am;
    this.preis = preis;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNr() {
    return nr;
  }

  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }

  public String getBild() {
    return bild;
  }
  
  public void setBild(String bild) {
    this.bild = bild;
  }

  /**
   * @return the erstelldatum
   */
  public Date getErstelldatum() {
    return erstelldatum;
  }

  /**
   * @param erstelldatum the erstelldatum to set
   */
  public void setErstelldatum(Date erstelldatum) {
    this.erstelldatum = erstelldatum;
  }
  
  
  /**
   * @return the gtin
   */
  public String getGtin() {
    return gtin;
  }

  /**
   * @param gtin the gtin to set
   */
  public void setGtin(String gtin) {
    this.gtin = gtin;
  }

  /**
   * @return the preis
   */
  public double getPreis() {
    return preis;
  }

  /**
   * @param preis the preis to set
   */
  public void setPreis(double preis) {
    this.preis = preis;
  }

}
