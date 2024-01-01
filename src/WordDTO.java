import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordDTO {
  public String word;
  public Map<WordDTO, Long> links = new HashMap<>();

  public boolean used = true;

  public WordDTO(String word) {
    this.word = word;
  }

  public void incrementLinks(String word) {
    Long linkedTimes = links.get(new WordDTO(word));
    if (linkedTimes == null) linkedTimes = 0L;
    linkedTimes++;
    links.put(new WordDTO(word), linkedTimes);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WordDTO wordDTO = (WordDTO) o;
    return Objects.equals(word, wordDTO.word);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word);
  }
}
