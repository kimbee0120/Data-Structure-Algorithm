/*****************************************************************************
 * Array Product
 * 
 * Given an array A[] of positive integers, return an array of integers whose 
 * k'th element is equal to the product of every integer in A[] except for the 
 * k'th element in A[].
 * 
 * Input: [1,1,2,5]
 * Output: [10, 10, 5, 2]
 * 
 * output[0] = 1*2*5 = 10
 * output[1] = 1*2*5 = 10
 * output[2] = 1*1*5 = 5
 * output[3] = 1*1*2 = 2
 ****************************************************************************************/
public class ArrayProduct 
{
    public int[] arrayProduct1(int[] arr)
    {
        int total = 1;
        for(int i=0; i<arr.length; i++)
        {
            total = total*arr[i];
        }

        for(int i=0; i<arr.length; i++)
        {
            arr[i] = total/arr[i];
        }

        return arr;
    }

    public int[] arrayProduct2(int[] arr)
    {
        int[] se = new int[arr.length];
        int[] es = new int[arr.length];

        se[0] = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            se[i] = arr[i]*se[i-1];
        }

        es[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--)
        {
            es[i] = arr[i]*es[i+1];
        }

        int[] answer = new int[arr.length];
        Arrays.fill(answer, 1);

        for(int i=0; i<arr.length; i++){

            if(i!=0){
                answer[i] = answer[i]*se[i-1];
            }

            if(i!= arr.length-1){
                answer[i] = answer[i]*es[i+1];
            }
        }

        return answer;
    }
}