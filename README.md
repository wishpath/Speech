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

TO DO LIST:
  fix first word repeating itself.
  chatGPT uses very rare words. What if I implement weight for how specific/uncommon is a word?
  further refactoring.
  clean up words from symbols.
  implement finding synonims. example examples
  research: theres already entry of map<Object, long>, whe key was created using "new Object(x)". Now i create Object newObject = new Object(x). can i get existing value by calling map.get(newObject) with another but equal object? (Object class has equals() and hashCode())
  
  

