package service;

import constants.Prop;

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
    putSpaceBeforeSymbolsAfterDot();
    removeIgnoredWords();
    removeMultipleSpaces();
  }

  private void removeIgnoredSymbols() {
    for (String ignoredSymbol : Prop.IGNORED_SYMBOLS_RGX) {
      this.processedText = this.processedText.replaceAll(ignoredSymbol, Prop.IGNORED_SYMBOLS_REPLACEMENT);
    }
  }

  private void replaceReplacableSymbols() {
    for (String replacableSymbol: Prop.REPLACABLE_SYMBOLS_RGX) {
      this.processedText = this.processedText.replaceAll(replacableSymbol, Prop.REPLACABLE_SYMBOLS_REPLACEMENT);
    }
  }

  private void putSpaceBeforeSymbolsAfterDot() {
    this.processedText = this.processedText.replaceAll("\\.(\\S)", "\\. $1");
  }

  private void removeIgnoredWords() {
    for (String ignoredWord : Prop.IGNORED_WORDS_RGX) {
      this.processedText = this.processedText.replaceAll(ignoredWord, Prop.IGNORED_WORDS_REPLACEMENT);
    }
  }
  private void removeMultipleSpaces() {
      this.processedText = this.processedText.replaceAll("\\s+", " ");
  }
}
