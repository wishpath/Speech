import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Set<WordDTO> set = new HashSet<>();
    String text = "Artificial intelligence (AI) is the intelligence of machines or software, as opposed to the intelligence of humans or animals. It is a field of study in computer science which develops and studies intelligent machines. Such machines may be called AIs.\n" +
        "\n" +
        "AI technology is widely used throughout industry, government, and science. Some high-profile applications are: advanced web search engines (e.g., Google Search), recommendation systems (used by YouTube, Amazon, and Netflix), understanding human speech (such as Google Assistant, Siri, and Alexa), self-driving cars (e.g., Waymo), generative and creative tools (ChatGPT and AI art), and superhuman play and analysis in strategy games (such as chess and Go).[1]\n" +
        "\n" +
        "Alan Turing was the first person to carry out substantial research in the field that he called Machine Intelligence.[2] Artificial intelligence was founded as an academic discipline in 1956.[3] The field went through multiple cycles of optimism[4][5] followed by disappointment and loss of funding.[6][7] Funding and interest vastly increased after 2012 when deep learning surpassed all previous AI techniques,[8] and after 2017 with the transformer architecture.[9] This led to the AI spring of the 2020s, with companies, universities, and laboratories overwhelmingly based in the United States pioneering significant advances in artificial intelligence.[10]\n" +
        "\n" +
        "The various sub-fields of AI research are centered around particular goals and the use of particular tools. The traditional goals of AI research include reasoning, knowledge representation, planning, learning, natural language processing, perception, and support for robotics.[a] General intelligence (the ability to complete any task performable by a human) is among the field's long-term goals.[11] To solve these problems, AI researchers have adapted and integrated a wide range of problem-solving techniques, including search and mathematical optimization, formal logic, artificial neural networks, and methods based on statistics, operations research, and economics.[b] AI also draws upon psychology, linguistics, philosophy, neuroscience and many other fields.[12]";
    text = text.toLowerCase();
    String[] words = text.split(" ");
    WordDTO previous = null;
    int i = -1;
    for (String word : words) {

      WordDTO wordDTO = getDTO(word, set);
      i++;
      if (i == 0) {
        previous = wordDTO;
        continue;
      }


      previous.incrementLinks(word);
      previous = wordDTO;
    }

    for (WordDTO word : set) {
      System.out.println(word.word + " " + word.links.size());
      for (Map.Entry<WordDTO, Long> w : word.links.entrySet()) System.out.println("     " + w.getKey().word + " " + w.getValue());
    }


    String start = "ai";
    WordDTO sentenceWord = null;
    for (WordDTO w : set) {
      if (w.word.equals(start) && w.used) {
        sentenceWord = w;
      }
    }
    System.out.print("generated text:\n\"" + sentenceWord.word + " ");
    int k = 0;
    for (int j = 0; j < 112; j++) {
      sentenceWord = getDTO2(sentenceWord.word, set);
      sentenceWord = getNext(sentenceWord, set);
      System.out.print(sentenceWord.word + " ");
    }
  }

  private static WordDTO getNext(WordDTO sentenceWord, Set<WordDTO> set) {
    getDTO2(sentenceWord.word, set).used = false;
    Map<WordDTO, Long> map = sentenceWord.links;
    Long max = -1L;
    WordDTO next = null;
    for (Map.Entry<WordDTO, Long> e: map.entrySet()) {
      if (e.getValue() > max && getDTO2(e.getKey().word, set).used) {
        next = e.getKey();
        max = e.getValue();
      }
    }
    if(next.word.equals("called"))
    if (next == null)
      System.out.println("not ok");
    return next;
  }


  private static WordDTO getDTO(String word, Set<WordDTO> set) {
    for (WordDTO w : set) {
      if (w.word.equals(word)) return w;
    }
    System.out.println("adding " + word );
    WordDTO naujas = new WordDTO(word);
    set.add(naujas);
    return naujas;
  }
  private static WordDTO getDTO2(String word, Set<WordDTO> set) {
    int i = 0;
    for (WordDTO w : set) {
      i++;
      if (w.word.equals(word)) {
        return w;
      }

    }
    System.out.println("" + word );
    return new WordDTO("___end___");
  }
}