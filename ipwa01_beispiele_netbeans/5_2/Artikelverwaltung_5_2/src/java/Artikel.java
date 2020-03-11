public class Artikel {

  private int nr;
  private String name;
  private String text;
  private String bild;
  
  public Artikel(){
  }

  public Artikel(int nr, String name, String text, String bild) {
    this.nr = nr;
    this.name = name;
    this.text = text;
    this.bild = bild;
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
}
