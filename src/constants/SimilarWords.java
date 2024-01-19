package constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarWords {
  public static final Map<String, List<String>> irregularTenses = new HashMap<>();
  public static final Map<String, List<String>> synonyms = new HashMap<>(); //this is singular not plural //present simple
  static {
    irregularTenses.put("be", List.of("is", "was"));
    synonyms.put("ai", List.of("artificial intelligence"));
    synonyms.put("human", List.of("people"));
    synonyms.put("intelligent", List.of("smart"));
    synonyms.put("technology", List.of("tech"));
    synonyms.put("use", List.of("utilize"));
    synonyms.put("computer science", List.of("computational science"));
    synonyms.put("machine intelligence", List.of("intelligence of machines"));
    synonyms.put("sophisticated", List.of("advanced"));
    synonyms.put("chess game", List.of("chess"));
    synonyms.put("funding reduction", List.of("loss of funding"));
    synonyms.put("educational institutions", List.of("universities"));
    synonyms.put("future objectives", List.of("long-term goals"));
    synonyms.put("software", List.of("program"));
    synonyms.put("animals", List.of("living beings"));
    synonyms.put("field of study", List.of("discipline"));
    synonyms.put("web search engines", List.of("online search platforms"));
    synonyms.put("recommendation systems", List.of("suggestion systems"));
    synonyms.put("understanding", List.of("comprehension"));
    synonyms.put("self-driving cars", List.of("autonomous vehicles"));
    synonyms.put("generative creative tools", List.of("creative AI tools"));
    synonyms.put("AI art", List.of("artificial intelligence generated art"));
    synonyms.put("strategy games", List.of("strategic games"));
    synonyms.put("Alan Turing", List.of("Turing"));
    synonyms.put("substantial research", List.of("significant investigation"));
    synonyms.put("machine intelligence", List.of("machine based intelligence"));
    synonyms.put("academic discipline", List.of("scholarly field"));
    synonyms.put("founded", List.of("established"));
    synonyms.put("cycles of optimism", List.of("phases of hopefulness"));
    synonyms.put("surpassed", List.of("exceeded"));
    synonyms.put("transformer architecture", List.of("transformer model"));
    synonyms.put("ai spring of 2020s", List.of("ai boom in the 2020s"));
    synonyms.put("companies", List.of("corporations"));
    synonyms.put("laboratories", List.of("research facilities"));
    synonyms.put("significant", List.of("notable"));
    synonyms.put("advance", List.of("progress"));
    synonyms.put("centered around", List.of("focused on"));
    synonyms.put("particular goals", List.of("specific objectives"));
    synonyms.put("use of particular", List.of("utilization of specific"));
    synonyms.put("goals", List.of("objective"));
    synonyms.put("reasoning", List.of("logical thinking"));
    synonyms.put("planning", List.of("strategic thinking"));
    synonyms.put("learning", List.of("acquiring knowledge"));
    synonyms.put("natural language processing", List.of("nlp"));
    synonyms.put("problem solving techniques", List.of("approaches to problem solving"));
    synonyms.put("search", List.of("exploration"));
    synonyms.put("mathematical optimization", List.of("math optimization"));
    synonyms.put("methods based on statistics", List.of("statistical approaches"));
    synonyms.put("operations research", List.of("operational analysis"));
    synonyms.put("economics", List.of("economic principles"));
    synonyms.put("linguistics", List.of("language studies"));
    synonyms.put("philosophy", List.of("philosophical principles"));
    synonyms.put("neuroscience", List.of("neural science"));
  }
}
