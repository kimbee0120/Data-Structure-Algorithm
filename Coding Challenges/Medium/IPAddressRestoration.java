/*********************************************************
 * Given a "raw" ip address string s, return all "restored"
 * ip address strings that can be recovered from s.
 * 
 * A "raw" ip address string is a string of digits that 
 * can have . marks inserted to create a valid ip address.
 * 
 * Input: "255255232132" Output: ["255.255.232.132"]
 * Example: There is only 1 way to restore this raw ip string
 * 
 * Input: "125523213"
 * Output:[
 * "1.255.23.213",
 * "1.255.232.13",
 * "12.55.23.213",
 * "12.55.232.13",
 * "125.5.23.213",
 * "125.5.232.13",
 * "125.52.3.213",
 * "125.52.32.13"]
 *********************************************************/
public class IPAddressRestoration {
    public List<String> restoreIpAddresses(String rawIp)
    {
        List<String> res = new ArrayList<>();

        saveIP(0,0,new int[4], res, rawIp);

        return res;
    }

    public void saveIP(int runIndex, int segNum, int[] tempSeg, List<String> res, String rawIp)
    {
        if(segNum == 4 && runIndex == rawIp.length()){
            res.add(addDot(tempSeg));
        }else if(segNum == 4){
            return;
        }

        for(int segLen = 1; segLen<=3 && (segLen+runIndex <= rawIp.length()); segLen++ )
        {
            int tempSegVal = runIndex+segLen;
            String segValString = rawIP.substring(runIndex, tempSegVal);
            int segVal = Integer.parseInt(segValString);

            if(segVal>255 || (segLen>=2 && segValString.charAt(0) == '0')){
                break;
            }

            tempSeg[segNum]=segVal;

            saveIP(runIndex+segLen, segNum+1,tempSeg, res, rawIP);
        }
    }

    public String addDog(int[] tempSeg)
    {
        return tempSeg[0]+"."+tempSeg[1]+"."+tempSeg[2]+"."+tempSeg[3];
    }
}