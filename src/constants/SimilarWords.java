package constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarWords {
  public static final Map<String, List<String>> irregularTenses = new HashMap<>();
  public static final Map<String, List<String>> SYNONYMS_MULTIPLE_WORDS = new HashMap<>(); //this is singular not plural //present simple
  public static final Map<String, List<String>> SYNONYMS_ONE_WORD = new HashMap<>(); //this is singular not plural //present simple
  static {
    irregularTenses.put("be", List.of("is", "was", "are"));
    SYNONYMS_ONE_WORD.put("natural language processing", List.of("nlp"));
    SYNONYMS_ONE_WORD.put("ai", List.of("artificial intelligence"));
    SYNONYMS_ONE_WORD.put("human", List.of("people"));
    SYNONYMS_ONE_WORD.put("intelligent", List.of("smart"));
    SYNONYMS_ONE_WORD.put("technology", List.of("tech"));
    SYNONYMS_ONE_WORD.put("use", List.of("utilize"));
    SYNONYMS_ONE_WORD.put("sophisticated", List.of("advanced"));
    SYNONYMS_ONE_WORD.put("software", List.of("program"));
    SYNONYMS_ONE_WORD.put("field of study", List.of("discipline"));
    SYNONYMS_ONE_WORD.put("understanding", List.of("comprehension"));
    SYNONYMS_ONE_WORD.put("Alan Turing", List.of("Turing"));
    SYNONYMS_ONE_WORD.put("founded", List.of("established"));
    SYNONYMS_ONE_WORD.put("surpassed", List.of("exceeded"));
    SYNONYMS_ONE_WORD.put("companies", List.of("corporations"));
    SYNONYMS_ONE_WORD.put("significant", List.of("notable"));
    SYNONYMS_ONE_WORD.put("advance", List.of("progress"));
    SYNONYMS_ONE_WORD.put("goals", List.of("objective"));




    SYNONYMS_MULTIPLE_WORDS.put("computer science", List.of("computational science"));
    SYNONYMS_MULTIPLE_WORDS.put("machine intelligence", List.of("intelligence of machines"));
    SYNONYMS_MULTIPLE_WORDS.put("funding reduction", List.of("loss of funding"));
    SYNONYMS_MULTIPLE_WORDS.put("educational institutions", List.of("universities"));
    SYNONYMS_MULTIPLE_WORDS.put("future objectives", List.of("long-term goals"));
    SYNONYMS_MULTIPLE_WORDS.put("animals", List.of("living beings"));
    SYNONYMS_MULTIPLE_WORDS.put("web search engines", List.of("online search platforms"));
    SYNONYMS_MULTIPLE_WORDS.put("recommendation systems", List.of("suggestion systems"));
    SYNONYMS_MULTIPLE_WORDS.put("self-driving cars", List.of("autonomous vehicles"));
    SYNONYMS_MULTIPLE_WORDS.put("AI art", List.of("artificial intelligence generated art"));
    SYNONYMS_MULTIPLE_WORDS.put("strategy games", List.of("strategic games"));
    SYNONYMS_MULTIPLE_WORDS.put("substantial research", List.of("significant investigation"));
    SYNONYMS_MULTIPLE_WORDS.put("machine intelligence", List.of("machine based intelligence"));
    SYNONYMS_MULTIPLE_WORDS.put("academic discipline", List.of("scholarly field"));
    SYNONYMS_MULTIPLE_WORDS.put("cycles of optimism", List.of("phases of hopefulness"));
    SYNONYMS_MULTIPLE_WORDS.put("transformer architecture", List.of("transformer model"));
    SYNONYMS_MULTIPLE_WORDS.put("ai spring of 2020s", List.of("ai boom in the 2020s"));
    SYNONYMS_MULTIPLE_WORDS.put("laboratories", List.of("research facilities"));
    SYNONYMS_MULTIPLE_WORDS.put("centered around", List.of("focused on"));
    SYNONYMS_MULTIPLE_WORDS.put("particular goals", List.of("specific objectives"));
    SYNONYMS_MULTIPLE_WORDS.put("use of particular", List.of("utilization of specific"));
    SYNONYMS_MULTIPLE_WORDS.put("reasoning", List.of("logical thinking"));
    SYNONYMS_MULTIPLE_WORDS.put("planning", List.of("strategic thinking"));
    SYNONYMS_MULTIPLE_WORDS.put("learning", List.of("acquiring knowledge"));
    SYNONYMS_MULTIPLE_WORDS.put("problem solving techniques", List.of("approaches to problem solving"));
    SYNONYMS_MULTIPLE_WORDS.put("mathematical optimization", List.of("math optimization"));
    SYNONYMS_MULTIPLE_WORDS.put("methods based on statistics", List.of("statistical approaches"));
    SYNONYMS_MULTIPLE_WORDS.put("operations research", List.of("operational analysis"));
    SYNONYMS_MULTIPLE_WORDS.put("economics", List.of("economic principles"));
    SYNONYMS_MULTIPLE_WORDS.put("linguistics", List.of("language studies"));
    SYNONYMS_MULTIPLE_WORDS.put("philosophy", List.of("philosophical principles"));
    SYNONYMS_MULTIPLE_WORDS.put("neuroscience", List.of("neural science"));
  }
}
