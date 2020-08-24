/****************************************************************************************************
 * Decode Ways
 * Given a string s that represents a special encoding, return the total ways that s can be decoded.
 ****************************************************************************************************/
public class DecodeWays 
{
    public int decodeWays(String s)
    {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return checkDecodeWays(s, 0, dp);
    }

    private int checkDecodeWays(String s, int curr_location, int[] dp)
    {
        if(curr_location >= s.length()){
            return 1;
        }

        if(dp[curr_location] != -1){
            return dp[curr_location];
        }

        int total = 0;
        for(int i=1; i<=2; i++)
        {
            if(curr_location+i <= s.length()){
                String st = s.substring(curr_location, curr_location+i);
                if(isValid(st)){
                    total += checkDecodeWays(s, curr_location+i, dp);
                }
            }
        }
        dp[curr_location] = total;
        
        return(dp[curr_location]);
    }

    boolean isValid(String s){
        if(s.length() ==0 || s.charAt(0) == '0'){
            return false;
        }

        int value = Integer.parseInt(s);
        return(value >0 && value < 27);
    }
}