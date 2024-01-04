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
    WordDTO sentenceWordObject = getWordObjectFromWordString(startingWordString);

    System.out.print("generated text:\n\"" + sentenceWordObject.word + " ");
    for (int j = 0; j < 112; j++) {
      //sentenceWordObject = getDTO2(sentenceWordObject.word);
      sentenceWordObject = getWordObjectFromWordString(sentenceWordObject.word);
      sentenceWordObject = getNext(sentenceWordObject);
      System.out.print(sentenceWordObject.word + " ");
    }
  }

  private WordDTO getWordObjectFromWordString(String start) {
    for (WordDTO w : set) {
      if (w.word.equals(start) && w.used) {
        return w;
      }
    }
    throw new RuntimeException("OutputSpeechMaker.getWordObjectFromWordString: No such word Object");
  }

  private WordDTO getNext(WordDTO sentenceWord) {
    getWordObjectFromWordString(sentenceWord.word).used = false;
    Map<WordDTO, Long> map = sentenceWord.links;
    Long max = -1L;
    WordDTO next = null;
    for (Map.Entry<WordDTO, Long> e : map.entrySet()) {
      if (e.getValue() > max && getDTO2(e.getKey().word).used) {
        next = e.getKey();
        max = e.getValue();
      }
    }
    if (next.word.equals("called"))
      if (next == null)
        System.out.println("not ok");
    return next;
  }

  private WordDTO getDTO2(String word) {
    for (WordDTO w : set) {
      if (w.word.equals(word)) {
        return w;
      }

    }
    System.out.println("" + word);
    return new WordDTO("___end___");
  }
}
