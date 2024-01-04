package helpers;

public class TextSplitter {

  private String text;

  public TextSplitter(String text) {
    this.text = text;
  }

  public String[] getWords() {
    return text.split(" ");
  }
}
