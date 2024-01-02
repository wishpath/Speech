import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Set<WordDTO> set = new HashSet<>();
    String text = new Input().getText();
    String[] words = new TextSplitter(text).getWords();
    constructGraph(set, words);
    printGraph(set);
    new Speaker(set).speak();
  }


  private static void printGraph(Set<WordDTO> set) {
    for (WordDTO word : set) {
      System.out.println(word.word + " " + word.links.size());
      for (Map.Entry<WordDTO, Long> w : word.links.entrySet()) System.out.println("     " + w.getKey().word + " " + w.getValue());
    }
  }

  private static void constructGraph(Set<WordDTO> set, String[] words) {
    WordDTO previous = null;
    WordDTO firstWordDTO = makeDTOandAddToSet(words[0], set);
    previous = firstWordDTO;
    for (int i = 1; i < words.length; i++) {
      String word = words[i];
      WordDTO wordDTO = makeDTOandAddToSet(word, set);
      previous.incrementLinks(word);
      previous = wordDTO;
    }
  }

  private static WordDTO makeDTOandAddToSet(String word, Set<WordDTO> set) {
    for (WordDTO w : set) {
      if (w.word.equals(word)) return w;
    }
    System.out.println("adding " + word );
    WordDTO naujas = new WordDTO(word);
    set.add(naujas);
    return naujas;
  }

}