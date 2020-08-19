/***********************************************************************************************************
 * Decompose String
 * Given an array dictionary[] consisting of a list of non-empty words along with 
 * a string s, determine if s can be decomposed into a sequence of zero or more dictionary words.
 *
 *  Example:
 * Input: s = "apple", dictionary = ["ap", "pl", "ppp", "pple"]
 * Output: false
 * Explanation: No combination of words in our dictionary can be put together to form “apple”. 
 * The closest we can get is “appl”, which is missing the last "e" character ("e" is not in the dictionary).
 ************************************************************************************************************/

public class DecomposeString {
    public boolean decompostString(List<String> candecompose, String s)
    {
        boolean[] dc = new boolean[s.length()+1];
        dc[0] = true;

        for(int i=1; i<=s.length(); i++)
        {
            for(int j=0; j<i; j++)
            {
                if(dp[j] && candecompose.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length];
    }
}

//Time complexity = O(M*N);
//Space complexity = O(N);