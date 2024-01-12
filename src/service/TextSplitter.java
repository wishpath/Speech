package service;

import constants.Prop;

import java.util.ArrayList;
import java.util.List;

public class TextSplitter {

  private String rawText;
  private String processedText;
  private List<String> nonPlurals = new ArrayList<>(List.of("is", "as", "analysis", "chess", "was", "loss", "previous", "various"));

  public TextSplitter(String rawText) {
    this.rawText = rawText;
    this.processedText = rawText;
    processText();
  }

  public String[] getWords() {
    String[] words = processedText.split(" ");
    return removePlural(words);
  }

  private String[] removePlural(String[] words) {
    for (String word : words) {
      if (word.matches(".*s")) {
        boolean skip = false;
        for (String s : nonPlurals) {
          if (s.equals(word)) skip = true;
        }
        if (skip) continue;
        word = word.substring(0, word.length() - 1);
        word.replaceAll("ie", "y");
        System.out.println(word);
      }
    }
    return words;
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
