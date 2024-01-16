package constants;

public class Props {
  public static final String[] IGNORED_SYMBOLS_RGX = new String[]{",", "\\(", "\\)", "\\[\\d+\\]", "\\[.{1}\\]", ":", "\\n", "\\'"};
  public static final String IGNORED_SYMBOLS_REPLACEMENT = "";
  public static final String[] REPLACABLE_SYMBOLS_RGX = new String[]{"-"};
  public static final String REPLACABLE_SYMBOLS_REPLACEMENT = " ";


  public static final String[] IGNORED_WORDS_RGX = new String[]{"\\bthe\\b", "\\ba\\b", "\\ban\\b", "\\band\\b"};
  public static final String[] NON_PLURALS = new String[]{"is", "as", "analysis", "chess", "was", "loss", "previous", "various", "linguistics", "this"};
  public static final String PLURAL_PATTERN = ".*s";
  public static final String IGNORED_WORDS_REPLACEMENT = "";


  public static final String[] WORDS_WITH_DOTS = new String[]{"e.g."};
  public static final String FAKE_DOT = "\u2024";
}
