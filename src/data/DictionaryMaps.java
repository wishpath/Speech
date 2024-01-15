package data;

import java.util.HashMap;
import java.util.Map;

public class DictionaryMaps {
  public static final Map<String, String> IRREGULAR_PLURALS = new HashMap<>();
  static {
    IRREGULAR_PLURALS.put("is", "\\bare\\b");
  }
}
