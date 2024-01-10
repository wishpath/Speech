package service.output;

import constants.Msg;
import data.WordDTO;
import service.input.Input;

import java.util.Map;
import java.util.Set;

public class OutputSpeechMaker {
  private Set<WordDTO> set;
  private String startingWordString = new Input().getStartingWordString();
  StringBuilder speech = new StringBuilder();

  public OutputSpeechMaker(Set<WordDTO> set) {
    this.set = set;
  }

  public void speak() {
    WordDTO sentenceWordObject = getWordObjectUsingWordString(startingWordString);
    speech.append(String.format(Msg.GENERATED_TEXT_INTRODUCTION_START, sentenceWordObject.wordString));
    for (int j = 0; j < 112; j++) {
      sentenceWordObject = getWordObjectUsingWordString(sentenceWordObject.wordString);
      markWordObjectAsUsed(sentenceWordObject);
      sentenceWordObject = getNext(sentenceWordObject);
      if (sentenceWordObject == null) break;
      speech.append(" ");
      speech.append(sentenceWordObject.wordString);
    }
    speech.append("\"");
    System.out.println(speech.toString().substring(0, speech.lastIndexOf(".") + 1));
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