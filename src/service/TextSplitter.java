package service;

import constants.Props;

public class TextSplitter {

  private String rawTextInput;
  private String processedTextOutput;

  public TextSplitter(String rawText) {
    this.rawTextInput = rawText;
    this.processedTextOutput = rawText;
    processText();
  }

  private void processText() {
    removeIgnoredSymbols();
    replaceReplacableSymbols();
    putSpaceBeforeSymbolsAfterDot();
    removeIgnoredWords();
    removeMultipleSpaces();
  }

  public String[] getWords() {
    String[] words = processedTextOutput.split(" ");
    System.out.println(words[6]);
    return removePlural(words);
  }

  private String[] removePlural(String[] words) {
    for (int i = 0; i < words.length; i++) {
      if (words[i].matches(Props.PLURAL_PATTERN)) {
        boolean skip = false;
        for (String s : Props.NON_PLURALS) {
          if (s.equals(words[i])) skip = true;
        }
        if (skip) continue;
        words[i] = words[i].substring(0, words[i].length() - 1);
        words[i] = words[i].replaceAll("ie$", "y");
      }
    }
    return words;
  }

  private void removeIgnoredSymbols() {
    for (String ignoredSymbol : Props.IGNORED_SYMBOLS_RGX) {
      this.processedTextOutput = this.processedTextOutput.replaceAll(ignoredSymbol, Props.IGNORED_SYMBOLS_REPLACEMENT);
    }
  }

  private void replaceReplacableSymbols() {
    for (String replacableSymbol: Props.REPLACABLE_SYMBOLS_RGX) {
      this.processedTextOutput = this.processedTextOutput.replaceAll(replacableSymbol, Props.REPLACABLE_SYMBOLS_REPLACEMENT);
    }
  }

  private void putSpaceBeforeSymbolsAfterDot() {
    this.processedTextOutput = this.processedTextOutput.replaceAll("\\.(\\S)", "\\. $1");
  }

  private void removeIgnoredWords() {
    for (String ignoredWord : Props.IGNORED_WORDS_RGX) {
      this.processedTextOutput = this.processedTextOutput.replaceAll(ignoredWord, Props.IGNORED_WORDS_REPLACEMENT);
    }
  }
  private void removeMultipleSpaces() {
      this.processedTextOutput = this.processedTextOutput.replaceAll("\\s+", " ");
  }
}
