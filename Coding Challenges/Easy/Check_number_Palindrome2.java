/**********************************************************************
 A palindrome is a sequence that reads the same forwards and backward.
 logrithm and mask approach 
 **********************************************************************/
class Check_number_Palindrome2
{
    public boolean isPalindrome(int x)
    {
        if(x<0) return false; //negative number cannot be a palindrome 
        int int_len = (int)Math.floor(Math.log10(x))+1; //length of the integer
        /**********************************************************
        log10(x) length of x-1.
        ex) if x is 1221 log10(1221) = 3.08672
                means 10^3.08672 = 1221
                Therefore, floor of 3.08672 is 3.0 and 3.0+1 is 4 
                which is length of the integer x. 
        **********************************************************/
        int mask_val = (int)Math.pow(10,(int_len-1)); //value of mask 
        /*********************************************************
        if x = 1221, we need to mask with 1000.
        1221 mask with 1000 will be 1.221 which allow to get the 
        first integer of x. 

        10^(int_len-1) will provide mask value 
        **********************************************************/

        //for loop will run until to reach to the middle integer
        for(int i=0; i<int_len/2; i++)
        {
            int first_num = x/mask_val; //get first place of x
            int last_num = x%10; //get last place of x
            
            //compare first_num and last_num
            if(first_num != last_num) return false;

            x = x%mask_val; //remove first place of x;
            x = x/10; //remove last place of x;
            mask_val = mask_val/100; // first and last integer removed. mask value need to remove 2 0's
        }

        return true;

    }
}