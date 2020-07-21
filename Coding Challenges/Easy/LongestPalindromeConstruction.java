import java.util.Map;

/*************************************************************************
 * Given a string, determine the length of the longest 
 * possible palindromic string that can be constructed 
 * using the characters of the string. 
 * 
 * Input: "aabbc" Output: 5 
 * Explanation: The longest palindromes possible are {"abcba", "bacab"}
 ***********************************************************************/
public class LongestPalindromeConstruction {
    
    //HashMap use
    public int longestPalidromeHash(String s)
    {
        Map<Character, Integer> charWithNum = new HashMap<>();

        //insert each character in s with counts
        for(int i=0; i<s.length(); i++)
        {
            char tempchar = s.charAt(i);
            if(charWithNum.containsKey(tempchar)){
                charWithNum.put(tempchar, charWithNum.get(tempchar)+1);
            }else{
                charWithNum.put(tempchar, 1);
            }
        }

        Character mostOftenChar = null;
        int mostOftenCharNum = 0;
        int longestPal = 0;

        for(Map.Entry<Character, Integer> c: charWithNum.entrySet())
        {
            char tempchar = c.getKey();
            int tempnum = c.getValue();

            //even value add-up to longestPal 
            if(tempnum%2 == 0){
                longestPal += tempnum;
            }else if(tempnum > mostOftenCharNum){
                mostOftenCharNum = tempnum;
                mostOftenChar = tempchar;
            }
        }

        if(mostOftenChar != null){
            longestPal += mostOftenCharNum;
            charWithNum.remove(mostOftenChar);
        }

        for(Map.Entry<Character, Integer> c: charWithNum.entrySet())
        {
            int tempnum = c.getValue();
            
            if(tempnum%2 != 0){
                longestPal += (tempnum-1);
            }
        }

        return longestPal;

        //time complexity = O(n)
        //space complexity = O(n)
    }

    //HashSet use
    public int longestPalidromeSet(String s)
    {
        Set<Character> set = new HashSet<>();
        int longest = 0;

        for(char c: s.toCharArray())
        {
            if(set.contains(c)){
                longest++;
                set.remove(c);
            }else{
                set.add(c);
            }
        }

        longest = longest*2;

        if(set.size()>0){
            longest++;
        }

        return longest;
    }
}