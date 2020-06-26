/*********************************************
*Given a set of strings words and a string 
*pattern return a list of all of the strings 
*in words that matches the pattern of the 
*pattern string.
**********************************************/
public class PatternMatching{
    public List<String> patternMatching(String[] words, String pattern)
    {
        List<String> result = new ArrayList<>();
    
        //check all words in words 
        for(int i=0; i< words.length; i++)
        {
        
            boolean isMatch = true;
            isMatch = checkPatter(words[i], pattern);
            
            if(isMatch)
            {
                result.add(words[i]);
            }
        }

        return result;
    }

    //check all characters in word 
    boolean checkPatter(String word, String pattern)
  {
    if(word.length() != pattern.length())
      return false;

    Hashtable<Character, Character> hash1 = new Hashtable<>();
    Hashtable<Character, Character> hash2 = new Hashtable<>();

    for(int i=0; i<word.length(); i++)
    {
      char patternchar = pattern.charAt(i);
      char wordchar = word.charAt(i);
      
      if(!hash1.containsKey(patternchar)){
        hash1.put(patternchar, wordchar);
      }
      if(!hash2.containsKey(wordchar)){
        hash2.put(wordchar, patternchar);
      }
      
      if(hash1.get(patternchar) != wordchar || hash2.get(wordchar) != patternchar){
        return false;
      }
  }
  return true;
}
}