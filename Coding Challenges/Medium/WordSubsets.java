/***************************************************************************************************
 * Given 2 sequences of strings A and B, determine all of the "universal" characters in A relative 
 * to B. Return the list of these universal characters.
 * 
 * A string a in A is "universal" relative to B if for each string in B (we will name b) a is a 
 * superset of b. This means that a has all of the characters in each b (ignoring order) in quantity 
 * at least.
 * 
 * Input: A = ["orange", "room", "more"] , B = ["rm", "oo"]
 * Output: ["room"]
 * 
 * Input: A = ["padding", "css", "randomcs"], B = ["cs", "c"]
 * Output: ["css", "randomcs"]
 *****************************************************************************************************/
public class WordSubsets {
    public List<String> wordSubsets(List<String> A, List<String> B)
    {
        int[] wordB = new int[26];

        for(String b: B)
        {
            int[] bcount = StringCharCount(b);
            
            for(int i=0; i<26; i++)
            {
                wordB[i] = Math.max(bcount[i], wordB[i]);
            }
        }

        List<String> res = new ArrayList<>();
        
        for(String a: A)
        {
            int[] acount = StringCharCount(a);
            boolean isSubString = true;
            for(int i=0; i<26; i++)
            {
                if(wordB[i]>acount[i]){
                    isSubString = false;

                }
            }
            if(isSubString){
                res.add(a);
            }
        }

        return res;

    }
    private int[] StringCharCount(String s)
    {
        int[] count = new int[26];
        for(char c: s.toCharArray())
        {
            int index = c - 'a';
            count[index] += 1;
        }

        return count;
    }
}