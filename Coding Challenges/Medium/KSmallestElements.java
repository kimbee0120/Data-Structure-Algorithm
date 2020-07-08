/*****************************************************
Given an integer array, return the K smallest integers
in the array. 

1) you can use Arrays.sort()
2) Without Arrays.sort()
******************************************************/

public class KSmallestElements
{
    public List<Integer> kSmallestElements1(int[] elements, int k)
    {
        Arrays.asList(elements); 
        Arrays.sort(elements);
    
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++){
        res.add(elements[i]);
    }
    
    return res;
    
    }

    public List<Integer> kSmallestElements2(int[] elements, int k)
    {
       // method1: PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
       // method2: PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
       // method3: PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b.compareTo(a)); 

       //if you are looking for k smallest elements => max heap
       //if you are looking for k largest elements => min heap

       PriorityQueue<Integer> maxheap = new PriorityQueue(Collections.reverseOrder());

       for(int element: elements)
       {
           maxheap.add(element);
           if(maxheap.size()>k){
               maxheap.poll();
           }
       }

       List<Integer> res = new ArrayList<>(maxheap)
       return res;
    }

    // Time complexity: O(n*log(k)) => intersion is log(k) and removal is log(k);
    // space complexity: O(k) => because the space hold max k item
}
