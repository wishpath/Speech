package constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarWords {
  public static final Map<String, List<String>> irregularTenses = new HashMap<>();
  public static final Map<String, List<String>> synonyms = new HashMap<>();
  static {
    irregularTenses.put("be", List.of("is", "was"));
    synonyms.put("ai", List.of("artificial intelligence"));
  }

}
