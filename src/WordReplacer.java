import constants.SimilarWords;

import java.util.List;
import java.util.Map;

public class WordReplacer {
  private String[] words;
  public WordReplacer(String[] words) {
    this.words = words;
  }


  public String[] replaceSynonyms() {
    for (String word : words) {
      word = replaceBySynonym(word);
    }
    return words;
  }

  private String replaceBySynonym(String word) {
    for(Map.Entry<String, List<String>> synonymSet: SimilarWords.SYNONYMS_ONE_WORD.entrySet()) {
      if (isInSynonymList(synonymSet.getValue(), word)) word = synonymSet.getKey();
    }
    return word;
  }

  private boolean isInSynonymList(List<String> listOfSynonyms, String word) {
    for (String synonym : listOfSynonyms) {
      if (word.equals(synonym)) {
        System.out.println(word + ": will be changed to synonym");
        return true;
      }
    }
    return false;
  }
}
