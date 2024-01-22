package service;

import constants.Props;
import constants.SimilarWords;

import java.util.Map;

public class TextSplitter {
  private String processedTextOutput;

  public TextSplitter(String rawText) {
    this.processedTextOutput = rawText;
    processText();
  }

  private void processText() {
    removeIgnoredSymbols();
    replaceReplacableSymbols();
    fakeDotsInWordsWithDots();
    putSpaceBeforeSymbolsAfterDot();
    replaceIrregularPlurals();
    removeIgnoredWords();
    removeMultipleSpaces();
  }

  private void replaceIrregularPlurals() {
    for (Map.Entry<String, String> e : SimilarWords.IRREGULAR_PLURALS.entrySet()) {
      String replacedPluralRegex = e.getValue();
      String replacement = e.getKey();
      processedTextOutput = processedTextOutput.replaceAll(replacedPluralRegex, replacement);
    }
  }

  private void fakeDotsInWordsWithDots() {
    for (String dottedWord : Props.WORDS_WITH_DOTS) {
      String fakeDottedReplacement = dottedWord.replaceAll("\\.", Props.FAKE_DOT);
      String regexToReplace = dottedWord.replaceAll("\\.", "\\\\.");

      processedTextOutput = processedTextOutput.replaceAll(regexToReplace, fakeDottedReplacement);
    }
  }

  public String[] getWords() {
    String[] words = processedTextOutput.split(" ");
    return removePlural(words);
  }

  private String[] removePlural(String[] words) {
    for (int i = 0; i < words.length; i++) {
      if (words[i].matches(Props.PLURAL_PATTERN_RGX)) {
        boolean skip = false;
        for (String s : Props.NON_PLURALS) {
          if (s.equals(words[i])) skip = true;
        }
        if (skip) continue;
        if (!words[i].matches(Props.ENDS_WITH_DOT_RGX)) words[i] = words[i].substring(0, words[i].length() - 1);
        else words[i] = words[i].substring(0, words[i].length() - 2) + ".";
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
    for (String replacableSymbol : Props.REPLACABLE_SYMBOLS_RGX) {
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

  public String getProcessedText() {
    return this.processedTextOutput;
  }
}
