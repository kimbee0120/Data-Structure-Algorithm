/******************************************************************************************
 * Testing For Cycles
 * 
 * Given the head of a linked list, determine whether the list has a cycle or not.
 * Return true if it does, otherwise, return false. 
 ******************************************************************************************/

 public class TestingForCycles {
    public boolean setTestForCycles(ListNode head)
    {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while(curr != null){
            if(set.contains(curr)){
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }

        return false;
        //Time Complexity = O(n);
        //Space Complexity = O(n);
    }

    public boolean twoptrTestForCycles(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;

        //Time Complexity = O(n);
        //Space Complexity = O(1);

        //How to check size of the cycle? 
        //when they are slow==fast, set the fast ptr and run slow (slow.next) until they meet and counts
        
        //How to check start ListNode of the cycle?
        //after the the size of the cycle, do window until left and right ptr are same.
    }


}