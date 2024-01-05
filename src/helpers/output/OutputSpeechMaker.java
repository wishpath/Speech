package helpers.output;

import data.WordDTO;
import helpers.input.Input;

import java.util.Map;
import java.util.Set;

public class OutputSpeechMaker {
  private Set<WordDTO> set;

  public OutputSpeechMaker(Set<WordDTO> set) {
    this.set = set;
  }

  public void speak() {
    String startingWordString = new Input().getStartingWordString();
    WordDTO sentenceWordObject = getWordObjectUsingWordString(startingWordString);

    System.out.print("\ngenerated text:\n\"" + sentenceWordObject.word + " ");
    for (int j = 0; j < 112; j++) {
      sentenceWordObject = getWordObjectUsingWordString(sentenceWordObject.word);
      sentenceWordObject = getNext(sentenceWordObject);
      System.out.print(sentenceWordObject.word + " ");
    }
  }

  private WordDTO getWordObjectUsingWordString(String start) {
    for (WordDTO w : set) {
      if (w.word.equals(start) && w.used) {
        return w;
      }
    }
    throw new RuntimeException("OutputSpeechMaker.getWordObjectUsingWordString: No such word Object");
  }

  private WordDTO getNext(WordDTO sentenceWord) {
    getWordObjectUsingWordString(sentenceWord.word).used = false;
    Map<WordDTO, Long> followingWordObjects = sentenceWord.links;
    Long max = -1L;
    WordDTO next = null;
    for (Map.Entry<WordDTO, Long> e : followingWordObjects.entrySet()) {
      if (e.getValue() > max && getDTO2(e.getKey().word).used) {
        next = e.getKey();
        max = e.getValue();
      }
    }
    return next;
  }

  private WordDTO getDTO2(String word) {
    for (WordDTO w : set) {
      if (w.word.equals(word)) {
        return w;
      }

    }
    throw new RuntimeException("OutputSpeechMaker.getWordObjectUsingWordString: No such word Object");
//
  }
}
