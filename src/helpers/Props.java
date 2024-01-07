package helpers;

public class Props {
  public static final String[] IGNORED_SYMBOLS_RGX = new String[]{",", "\\(", "\\)", "\\[\\d+\\]", "\\[.{1}\\]", ":", "\\n"};
  public static final String IGNORED_SYMBOLS_REPLACEMENT = "";
  public static final String[] REPLACABLE_SYMBOLS_RGX = new String[]{"-"};
  public static final String REPLACABLE_SYMBOLS_REPLACEMENT = " ";

  public static final String[] IGNORED_WORDS_RGX = new String[]{"\\bthe\\b", "\\ba\\b", "\\ban\\b"};
  public static final String IGNORED_WORDS_REPLACEMENT = "";


  public static final String[] SPECIAL_WORDS = new String[]{"e.g."};
}
