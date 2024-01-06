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
    System.out.println(sentenceWordObject.wordString + " " + sentenceWordObject.used);


    System.out.print("\ngenerated text:\n\"" + sentenceWordObject.wordString + " ");
    for (int j = 0; j < 112; j++) {
      sentenceWordObject = getWordObjectUsingWordString(sentenceWordObject.wordString);
      sentenceWordObject = getNext(sentenceWordObject);
      System.out.print(sentenceWordObject.wordString + " ");
    }
  }

  private WordDTO getWordObjectUsingWordString(String start) {
    for (WordDTO w : set) {
      if (w.wordString.equals(start)) {
        return w;
      }
    }
    throw new RuntimeException("OutputSpeechMaker.getWordObjectUsingWordString: No such word Object");
  }

  private WordDTO getNext(WordDTO sentenceWord) {
    getWordObjectUsingWordString(sentenceWord.wordString).used = false;
    Map<WordDTO, Long> followingWordObjects = sentenceWord.linkedTimes;
    Long max = -1L;
    WordDTO next = null;
    for (Map.Entry<WordDTO, Long> e : followingWordObjects.entrySet()) {
      if (e.getValue() > max && getWordObjectUsingWordString(e.getKey().wordString).used) {
        next = e.getKey();
        max = e.getValue();
      }
    }
    return next;
  }
}
