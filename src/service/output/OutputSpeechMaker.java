package service.output;

import constants.Msg;
import data.WordDTO;
import service.input.Input;

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


    System.out.print("\ngenerated text:\n\"" + sentenceWordObject.wordString + " ");
    for (int j = 0; j < 112; j++) {
      sentenceWordObject = getWordObjectUsingWordString(sentenceWordObject.wordString);
      markWordObjectAsUsed(sentenceWordObject);
      sentenceWordObject = getNext(sentenceWordObject);
      System.out.print(sentenceWordObject.wordString + " ");
    }
  }

  private void markWordObjectAsUsed(WordDTO sentenceWordObject) {
    getWordObjectUsingWordString(sentenceWordObject.wordString).used = true;
  }

  private WordDTO getWordObjectUsingWordString(String wordString) {
    for (WordDTO wordObject : set) {
      if (wordObject.wordString.equals(wordString)) {
        return wordObject;
      }
    }
    throw new RuntimeException(Msg.WORD_OBJECT_NOT_FOUND);
  }


  private WordDTO getNext(WordDTO sentenceWord) {
    Map<WordDTO, Long> followingWordObjects = sentenceWord.linkedTimes;
    Long max = -1L;


    WordDTO next = null;
    for (Map.Entry<WordDTO, Long> e : followingWordObjects.entrySet()) {
      if (e.getValue() > max && !getWordObjectUsingWordString(e.getKey().wordString).used) {
        next = e.getKey();
        max = e.getValue();
      }
    }
    return next;
  }
}