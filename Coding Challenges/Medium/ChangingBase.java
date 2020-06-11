/**********************************************************************************
 * Given an integer (represented as a string) under base b1, convert it to base b2.
 * ex) Input ("12", 10, 2) 
 *     Output "1100"
 * 
 *     Input ("123", 4, 10)
 *     Output "27"
 *     => 1*(4^2)+2*(4^1)+3*(4^0) == 27
 * 
 *     Input ("123", 4, 16)
 *     Output "1B"
 *     => 1*(4^2)+2*(4^1)+3*(4^0) == 27
 *     => 27%16 =11 //B
 *     => 27/16 = 1.68 // 1
 *     => 1B 
 * Ascii code
 * 'A' - 'A' == 0
 * 'B' - 'A' == 1
 * 'C' - 'A' == 2
 * 'A' + 1 == 'B' || 11 
 * 'A' + 4 == 'E' || 14
 * 
 * this will return Integer, if you want to get as char, use (char)
 * 
 *  
 */
class ChangingBase
{
    public String changeBase(String numstr, int b1, int b2)
    {
        boolean isPos = !(numstr.startsWith("-")); // check if the given num is positive or negative
        int startIndex = isPos? 0: 1; // if the num is negative, it will start from 1 
        int maxPow = numstr.length()-1; // max power is from 0 to the length-1;
        int decimalVal = 0;

        //change numstr to decimal 
        for(int i=startIndex; i<numstr.length(); i++)
        {
            int isdigit = Character.isDigit(numstr.charAt(i)); //check if char is digit or Hex
            int tempVal = isdigit ? (numstr.charAt(i)-'0') : (numstr.charAt(i)-'A')+10; // if char, just -'0' to get the int val.
            //if it's Hex, Hex char -'A' and +10 add int decimal val

            decimalVal += tempVal * (int)(Math.pow(b1, maxpow));
            maxpow --;
        }

        if(decimalVal == 0) return "0";
        
        return isPost ? "":"-" + decToBase(decimalVal, b2);
    }

    //change decimal value to b2 value;
    String decToBase(int decimal, int base)
    {
        if(decimal==0) return "";

        Character value;
        int mod = decimal%base; // check remainder to change
        boolean isHexNeed = mod>=10; //if mod >= 10 means they need hex 
        if(isHexNeed)
            value = (char)((mod-10)+'A'); // it will give you hex value in Character
        else
            value = (char)(mod-'0');// it will give int character 
        
        int dec_rest = decimal/base; //devide for next convert

        return decToBase(dec_rest, base)+dec_rest;
    }
}