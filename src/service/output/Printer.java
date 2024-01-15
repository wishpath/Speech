package service.output;

import data.WordDTO;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

public class Printer {
  public static void printGraph(Set<WordDTO> set) {
    for (WordDTO word : set) {
      System.out.println(word.wordString + " " + word.linkedTimes.size());
      for (Map.Entry<WordDTO, Long> w : word.linkedTimes.entrySet())
        System.out.println("     " + w.getKey().wordString + " " + w.getValue());
    }
  }
  public static void printSpecificWord(Set<WordDTO> set, String specificWord) {
    for (WordDTO word : set) {
      if (!word.wordString.equals(specificWord)) continue;
      System.out.println(word.wordString + " " + word.linkedTimes.size());
      for (Map.Entry<WordDTO, Long> w : word.linkedTimes.entrySet())
        System.out.println("     " + w.getKey().wordString + " " + w.getValue());
    }
  }

  public static void printSpecialCharacters(String s) {
    String set = "UTF-8";
    try {
      new PrintStream(System.out, true, set).println(new String(s.getBytes(set) , set));
    } catch (UnsupportedEncodingException e) {}
  }
}
