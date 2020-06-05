/**********************************************************************
 A palindrome is a sequence that reads the same forwards and backward.
 get reverse integer of x
 **********************************************************************/
class Check_number_Palindrome
{
    public boolean isPalindrome(int x)
    {
        int original = x; //copy x to compare later
        int copy = 0; //this value will be reverse value 

        //while x is bigger than 0, keep remove remainder 
        while(x>0)
        {
          int temp = x%10; //remainder (end integer of x) if x=123, the first temp will be 3
          copy = copy*10+temp; //when temp is available, saved copy number should increase *10
          
          x = x/10; //remove remainder 
        }
        
        //compare original and copy
        if(original != copy) return false;
        
        return true;

    }
}