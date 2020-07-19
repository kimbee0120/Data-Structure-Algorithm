/**************************************************************************
 * K Largest Elements In An Immutable Max-Heap
 * 
 * Given a max-heap in array representation, return the k largest elements 
 * in the heap without performing explicit removals from the max-heap 
 * (the heap is immutable).
 * 
 * Input: heap = [17, 7, 16, 2, 3, 15, 14] k = 2
 * Output: [17, 16]
 * 
 * How to find left and right child index?
 * Left: (2*p)+1
 * Right: (2*p)+2
 * 
 * How to find Parent index?
 * Parent: (c-1)/2
 ***************************************************************************/


public class KLargestElementsImmutable 
{
    public List<Integer> KLargestHeap(int[] immutableHeap, int k)
    {
        if(k<=0){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        PriorityQueue<HeapItem> maxcandidate = new PriorityQueue<>(MaxHeapComparator());
        maxcandidate.add(new HeapItem(0, immutableHeap[0]));

        for(int i=0; i<k; i++)
        {
            HeapItem candidate = maxcandidate.poll();
            res.add(candidate.value);

            int leftindex = candidate.getLeftChildIndex();
            if(leftindex < immutableHeap.length){
                maxcandidate.add(new HeapItem(leftindex, immutableHeap[leftindex]));
            }

            int rightindex = candidate.getRightChildIndex();
            if(rightindex < immutableHeap.length){
                maxcandidate.add(new HeapItem(rightindex, immutableHeap[rightindex]));
            }
        }

        return res;
    }

    class MaxHeapComparator implements Comparator<HeapItem>
    {
        public int compare(HeapItem a, HeapItem b){
            return Integer.compare(b.value, a.value);
        }
    }

    class HeapItem
    {
        int index;
        int value;

        public HeapItem(int index, int value){
            this.index = index;
            this.value = value;
        }

        int getParentsIndex(){
            return (index-1)/2;
        }

        int getLeftChildIndex(){
            return (2*index)+1;
        }

        int getRightChildIndex(){
            return (2*index)+2;
        }
    }
}