import java.util.Map;
import java.util.Set;

public class Speaker {
  private Set<WordDTO> set;

  public Speaker(Set<WordDTO> set) {
    this.set = set;
  }

  public void speak() {
    String start = new Input().getStartingWord();
    WordDTO sentenceWord = null;
    for (WordDTO w : set) {
      if (w.word.equals(start) && w.used) {
        sentenceWord = w;
      }
    }
    System.out.print("generated text:\n\"" + sentenceWord.word + " ");
    int k = 0;
    for (int j = 0; j < 112; j++) {
      sentenceWord = getDTO2(sentenceWord.word, set);
      sentenceWord = getNext(sentenceWord, set);
      System.out.print(sentenceWord.word + " ");
    }
  }

  private static WordDTO getNext(WordDTO sentenceWord, Set<WordDTO> set) {
    getDTO2(sentenceWord.word, set).used = false;
    Map<WordDTO, Long> map = sentenceWord.links;
    Long max = -1L;
    WordDTO next = null;
    for (Map.Entry<WordDTO, Long> e: map.entrySet()) {
      if (e.getValue() > max && getDTO2(e.getKey().word, set).used) {
        next = e.getKey();
        max = e.getValue();
      }
    }
    if(next.word.equals("called"))
      if (next == null)
        System.out.println("not ok");
    return next;
  }

  private static WordDTO getDTO2(String word, Set<WordDTO> set) {
    int i = 0;
    for (WordDTO w : set) {
      i++;
      if (w.word.equals(word)) {
        return w;
      }

    }
    System.out.println("" + word );
    return new WordDTO("___end___");
  }
}
