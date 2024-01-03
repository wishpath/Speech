import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    String text = new Input().getText();
    String[] words = new TextSplitter(text).getWords();
    Set<WordDTO> set = new GraphMaker(words).makeGraph();
    new OutputSpeechMaker(set).speak();
  }

  private static void printGraph(Set<WordDTO> set) {
    for (WordDTO word : set) {
      System.out.println(word.word + " " + word.links.size());
      for (Map.Entry<WordDTO, Long> w : word.links.entrySet()) System.out.println("     " + w.getKey().word + " " + w.getValue());
    }
  }
}