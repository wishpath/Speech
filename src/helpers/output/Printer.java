package helpers.output;

import data.WordDTO;

import java.util.Map;
import java.util.Set;

public class Printer {
  private static void printGraph(Set<WordDTO> set) {
    for (WordDTO word : set) {
      System.out.println(word.word + " " + word.links.size());
      for (Map.Entry<WordDTO, Long> w : word.links.entrySet())
        System.out.println("     " + w.getKey().word + " " + w.getValue());
    }
  }
}
