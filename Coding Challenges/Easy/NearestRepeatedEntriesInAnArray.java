import java.util.HashMap;

/****************************************************************
 * Given an array words of words return the distance between the 
 * nearest repeated entries.
 * 
 * If no entry is repeated return -1.
 * 
 * Input:[
  "This",
  "is",
  "a",
  "sentence",
  "with",
  "is",
  "repeated",
  "then",
  "repeated"]
  
  Output: 2
 ****************************************************************/


public class NearestRepeatedEntriesInAnArry
{
    public int distanceOfClosestRepeatedEntries(String[] sentence)
    {
       HashMap<String, Integer> map = new HashMap<>();
        shortest = Integer.MAX_VALUE;

       for(int i=0; i<sentence.length; i++)
       {
           if(!map.containsKey(sentence[i])){
               map.put(sentence[i], i);
           }else{
               int tempind = map.get(sentence[i]);
               int tempdiff = i-tempind;
               if(tempdiff<shortest){
                   shortest = tempdiff;
               }

               map.put(sentence[i], i); //update 
           }
       }

       if(shortest== Integer.MAX_VALUE){
           return -1;
       }else{
           return shortest;
       }
    }
}