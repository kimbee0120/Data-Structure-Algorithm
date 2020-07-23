import java.util.Map;

/*********************************************************************
 * Given a string s, return the length of the longest substring of s 
 * without repeating characters.
 * 
 * Input: : "ABCABADEC" Output: 5
 * Explanation: Though there are substrings such as "AB" and "ABC" 
 * that have all unique characters, "BADEC" is the longest unique 
 * character substring.
 ********************************************************************/

public class LongestSubstringWithoutRepeating {
    public int longestSubstring(String s)
    {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++)
        {
            char tempchar = s.charAt(i);
            if(map.containsKey(tempchar) && left<=map.get(tempchar)){
                left = map.get(tempchar);
            }

            map.put(tempchar, i);

            max = Math.max(max, (i-left)+1);
        }

        return max;
    }
}