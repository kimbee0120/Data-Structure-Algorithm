/***************************************************************
 * Given a non-negative integer input, return true if input is a
 *  power of 4. Return false otherwise.
 * 
 * First, keep in mind input AND input-1 should be 0 
 *  * 1 = 1
 * 4 = 100
 * if we subtract -1 from this power of two numbers
 * 1-1 = 0
 * 4-1 = 011
 * 
 * Second, power of 4 in binary is 
 * 00000000000000001
 * 00000000000000100
 * 00000000000010000
 * 00000000001000000
 * 00000000100000000
 * 
 * which is 1 is only in odd number, 
 * this can be mask with HEX 0x55555555 == 1010101010101010101010101010101
 * all odd bits set as 1 and all even bits as 0
 * 
 */
public class PowerOfFour
{
    public boolean powerOfFour(int input)
    {
        return (input>0 && (input & input-1) == 0) && (input&0x55555555)==input;
    }
}

/* Time complexity = 0(1)*/