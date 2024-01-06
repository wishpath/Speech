package helpers;

public class TextSplitter {

  private String rawText;
  private String processedText;

  public TextSplitter(String rawText) {
    this.rawText = rawText;
    this.processedText = rawText;
    processText(rawText);
  }

  public String[] getWords() {
    return processedText.split(" ");
  }

  private void processText(String rawText) {
    removeIgnoredSymbols();
    replaceReplacableSymbols();
    makeSureThereAreSpacesAfterDots();
  }

  private void removeIgnoredSymbols() {
    for (String ignoredSymbol : Props.IGNORED_SYMBOLS_RGX) {
      this.processedText = this.processedText.replaceAll(ignoredSymbol, Props.IGNORED_SYMBOLS_REPLACEMENT);
    }
  }

  private void replaceReplacableSymbols() {
    for (String replacableSymbol: Props.REPLACABLE_SYMBOLS_RGX) {
      this.processedText = this.processedText.replaceAll(replacableSymbol, Props.REPLACABLE_SYMBOLS_REPLACEMENT);
    }
  }

  private void makeSureThereAreSpacesAfterDots() {
    this.processedText = this.processedText.replaceAll("\\.(\\S)", "\\. $1");
  }
}
