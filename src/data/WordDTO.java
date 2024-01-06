package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordDTO {
  public String wordString;
  public Map<WordDTO, Long> linkedTimes = new HashMap<>();

  public boolean used = false;

  public WordDTO(String wordString) {
    this.wordString = wordString;
  }

  public void incrementLinks(String wordString) {
    Long linkedTimes = this.linkedTimes.get(new WordDTO(wordString));
    if (linkedTimes == null) linkedTimes = 0L;
    linkedTimes++;
    this.linkedTimes.put(new WordDTO(wordString), linkedTimes);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WordDTO wordDTO = (WordDTO) o;
    return Objects.equals(wordString, wordDTO.wordString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wordString);
  }
}
