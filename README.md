Idea:
  • Based on popular description of ChatGPT, that "it's only guessing each next word". 
  • What would be result of an algorithm that literaly does this: only predicts each next word? What would it say?

v1:
  input: raw text and then a single word existing in this text
    raw text: https://en.wikipedia.org/wiki/Artificial_intelligence
    single word: "ai"
  model: cutting text into word objects and forming a graph
  output: starting with a single word and looping each next word that is most probable (and is not used already).
  result:
    ![image](https://github.com/wishpath/Speech/assets/117854313/c463ac6b-d688-4498-ad00-224ffcc15a85)

