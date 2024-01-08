package service;

public class TextSplitter {

  private String rawText;
  private String processedText;

  public TextSplitter(String rawText) {
    this.rawText = rawText;
    this.processedText = rawText;
    processText();
  }

  public String[] getWords() {
    return processedText.split(" ");
  }

  private void processText() {
    removeIgnoredSymbols();
    replaceReplacableSymbols();
    fixSpacesAfterDots();
//    removeIgnoredWords();
//    removeMultipleSpaces();
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

  private void fixSpacesAfterDots() {
    this.processedText = this.processedText.replaceAll("\\.(\\S)", "\\. $1");
  }

  private void removeIgnoredWords() {
    for (String ignoredWord : Props.IGNORED_WORDS_RGX) {
      this.processedText = this.processedText.replaceAll(ignoredWord, Props.IGNORED_WORDS_REPLACEMENT);
    }
  }
  private void removeMultipleSpaces() {
      this.processedText = this.processedText.replaceAll("\\s+", " ");
  }
}
