
/**
 *
 * @author Marian
 */
public class Benutzer {
  private String name;
  private String passwort;

  public Benutzer() {
  }
  
  public Benutzer(String name, String passwort) {
    this.name = name;
    this.passwort = passwort;
  }
  
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the passwort
   */
  public String getPasswort() {
    return passwort;
  }

  /**
   * @param passwort the passwort to set
   */
  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Benutzer)
    {
      Benutzer b = (Benutzer) obj;
      if (b.getName().equals(this.name) && 
                b.getPasswort().equals(this.passwort))
          return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
    hash = 53 * hash + (this.passwort != null ? this.passwort.hashCode() : 0);
    return hash;
  }

}
