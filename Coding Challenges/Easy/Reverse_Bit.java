/********************************************************
 * Given an input integer input, 
 * return the integer value of input's bits reversed. 
 * You will only be reversing the "significant portion" 
 * of the binary representation (ignoring leading zeros).
 * 
 * Hint) Bitwise Operation 
 *********************************************************/

 public class Reverse_Bits
 {
     public int reverseBit(int x)
     {
         int result = 0;

         //while x is bigger than 0, it will keep get the binary number. 
         //ex) 00000101 ==> 101 (instead of 10100000)
         while(x != 0)
         {
            result = result << 1; // shift 1 left to input binary number 

            /************************************************************
             * x = 10 which is 00001010 in binary 
             * shift left << 1 will shift one left 00010100
             * shift right >> 1 will shift one right 0000101
             * 
             * & is bitwise AND operation in Java 
             * | is bitwise OR operation in Java
             * 1&1 = 1, 0&1 = 0    ex)..10110110 & ..00000001 = 0 (even), ..10110111 & ..00000001 = 1 (odd)
             * 0|0 = 0, 1|0 = 1
             ***********************************************************/
            if((x & 1) == 1)
                result = result | 0; 

            x = x >> 1; //shift right 
         }
     }
 }