Idea:
  • Based on popular description of ChatGPT, that "it's only guessing each next word". 
  • What would be result of an algorithm that literally does this: only predicts each next word? What would it say?

v1.0:
  input: raw text and then a single word existing in this text.
raw text: https://en.wikipedia.org/wiki/Artificial_intelligence
single word: "ai"
model: cutting text into word objects and forming a graph
  output: starting with a single word and looping each next word that is most probable (and is not used already).
  result:
    ![image](https://github.com/wishpath/Speech/assets/117854313/c463ac6b-d688-4498-ad00-224ffcc15a85)

  v1.1:
    input raw text is now cleaned before further process.
    result:
      ![image](https://github.com/wishpath/Speech/assets/117854313/b771a783-e329-4be3-8e5b-05d3aa2ca3aa)


TO DO LIST:
  go to v 1.2
  chatGPT uses very rare words. What if I implement weight for how specific/uncommon is a word?
  implement finding synonims. example examples
  another but equal object? (Object class has equals() and hashCode())
  make readme nice!
  maybe ignore some words like "the". its kind of the part of a next word. and theres no much patters what comes after "the". It could be figured out where to put articles, while processing the output. 

SELF NOTES:
  do not add field "endOfSentence" or remove dot from the word. "example" and "example." are very different regarding what words follow after it.
