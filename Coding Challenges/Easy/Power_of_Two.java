/*********************************************************
 * Given a non-negative integer input, return true if 
 * input is a power of two. Return false otherwise.
 ********************************************************/

public class Power_of_Two 
{
    public boolean powerOfTwo(int x)
    {
        //if x is negative or 0, it cannot be a power of two 
        /************************************************************
         * if x is power of two, then x(x-1) will be 0 
         * power of 2 is 1, 2, 4, 8, ... this number in binary 
         * 1 = 1
         * 2 = 10
         * 4 = 100
         * 8 = 1000
         * if we subtract -1 from this power of two numbers
         * 1-1 = 0
         * 2-1 = 01
         * 4-1 = 011
         * 8-1 = 0111 
         **************************************************************/
         
         //if both case is correct, it will return true 
         return (x > 0 && (x&(x-1)) == 0);
    }
}

