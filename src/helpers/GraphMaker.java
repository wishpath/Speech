package helpers;

import data.WordDTO;

import java.util.HashSet;
import java.util.Set;

public class GraphMaker {
  private Set<WordDTO> set = new HashSet<>();
  private String[] words;

  public GraphMaker(String[] words) {
    this.words = words;
  }

  public Set<WordDTO> makeGraph() {
    WordDTO previous = new WordDTO(words[0]);
    set.add(previous);
    for (int i = 1; i < words.length; i++) {
      previous = dealWithStringWord(previous, words[i]);
    }
    return set;
  }

  private WordDTO dealWithStringWord(WordDTO previous, String word) {
    WordDTO wordDTO = ifPresentInSetThenReturnObjectFromSetOtherwiseMakeNewDTOAddToSetAndReturnNewDTO(word);
    previous.incrementLinks(word);
    return wordDTO;
  }

  private WordDTO ifPresentInSetThenReturnObjectFromSetOtherwiseMakeNewDTOAddToSetAndReturnNewDTO(String word) {
    for (WordDTO w : set) {
      if (w.word.equals(word)) return w;
    }
    WordDTO newDTO = new WordDTO(word);
    set.add(newDTO);
    return newDTO;
  }
}
