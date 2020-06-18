/********************************************************
 * Given an integer value n, enumerate all prime numbers 
 * from 1 to n (exclusive) and return the list with the 
 * enumeration.
 * 
 * Prime number = only available devide by 1 and self
 *                under 2 is cannot be prime number
 ********************************************************/
public class AllPrimesToN 
{
    /*Brute Force Solution */
    public List<Integer> allPrimes(int n)
    {
        List<Integer> list = new ArrayList<>();

        if(n<2) return list;

        //check if 0 to n contains prime number, if they do add to the list
        for(int i=2; i<n; i++)
        {
            boolean isPrime = true; 
            int j=2;
            while(j<i)
            {
                //non of previous number of i shouldn't available to devide
                if(i%j == 0)
                {
                    isPrime = false;
                }
                j++
            }

            if(isPrime)
            {
                list.add(i);
            }
        }

        return list;
    }
    //Time complexity = O(n^2)
    //Space Complexity = O(n)


    /* improve */
    public List<Integer> allPrimes2(int n)
    {
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        if(n<2) return list;

        for(int i=0; i<n; i++)
        {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=0; i<n; i++)
        {
            if(isPrime[i])
            {
                //i=2,3,5,7 is Prime number therefore, you should check from 4 and 6
                //loglogn 
                for(int j=i+i; j<n; j+=i)
                {
                    isPrime[j]=false;
                }
            }
            list.add(i);
        }

        return list;
    }

    //Time complexity = O(nloglogn)
    //Space Complexity = O(n)

}


