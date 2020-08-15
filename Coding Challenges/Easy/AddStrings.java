/********************************************************************************
 * Add Strings
 * 
 * Given two strings s1 and s2 consisting of only 1's and 0's, return a string 
 * representing the sum of s1 and s2 when they are considered as base-10 decimal 
 * numbers.
 * 
 * Input: s1 = "95", s2 = "7" 
 * Output: "102" 
 * Explanation: The sum of 95 and 7 is 102.
 *********************************************************************************/
public class AddStrings
{
    public String addStrings(String s1, String s2)
    {
        int s1_len = s1.length()-1;
        int s2_len = s2.length()-1;

        StringBuilder sb = new StringBuilder();

        int carry = 0;

        while(s1_len >= 0 || s2_len >=0)
        {
            int sum = carry;
            if(s1_len >=0)
            {
                sum+= s1.charAt(s1_len)-'0';
                s1_len--;
            }
            if(s2_len >=0)
            {
                sum+= s2.charAt(s2_len)-'0';
                s2_len--;
            }

            sb.append(sum%10);
            carry = sum/10;
        }

        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}