import java.util.Arrays;

/******************************************************************************
 * Given a string digits representing a phone number, return all possible 
 * character arrangements that can result from the number.
 * 
 * 2 -> "a" || "b" || "c"
 * 3 -> "d" || "e" || "f"
 * 4 -> "g" || "h" || "i"
 * 5 -> "j" || "k" || "l"
 * 6 -> "m" || "n" || "o"
 * 7 -> "p" || "q" || "r" || "s"
 * 8 -> "t" || "u" || "v"
 * 9 -> "w" || "x" || "y" || "z"
 * 
 * Input: "43"
 * Output: ["gd","ge","gf","hd","he","hf","id","ie","if"]
 * 
 * Input: "239"
 * Output:[
 * "adw","adx","ady","adz",
 * "aew","aex","aey","aez",
 * "afw","afx","afy","afz",
 * "bdw","bdx","bdy","bdz",
 * "bew","bex","bey","bez",
 * "bfw","bfx","bfy","bfz",
 * "cdw","cdx","cdy","cdz",
 * "cew","cex","cey","cez",
 * "cfw","cfx","cfy","cfz"]
 ****************************************************************************/

public class PhoneNumberMenemonics {
    private List<String> savedDigits = Arrays.asList(
        "", //0
        "", //1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    );

    public List<String> letterCombinations(String digits)
    {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        getLetterList(res, 0, new StringBuilder(), digits);

        return res;
    }

    void getLetterList(List<String> res, int currIndex, StringBuilder partial, String digits)
    {
        if(currIndex== digits.length()){
            res.add(partial.toString());
            return;
        }

        int currentNum = digits.charAt(currIndex)-'0';
        String currDigits = savedDigits.get(currentNum);

        for(char digit: currDigits.toCharArray())
        {
            partial.append(digit);
            getLetterList(res, currIndex+1, partial, digits);
            partial.deleteCharAt(partial.length-1);
        }
    }
}

//Time complexity = O(4^n);

//4 branches with n depth.
//max each index letter are 4; at 7 and 9
