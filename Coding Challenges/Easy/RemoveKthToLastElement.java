/***************************************************************************************
 * Remove kth To Last Element
 * Given a linked list, remove the k'th to last element, and return the head of the new 
 * linked list.
 * 
 * Input:k = 2, 1 -> 2 -> 5 -> 6 -> 7 -> X
 * Output: 1 -> 2 -> 5 -> 7 -> X
 * Explanation: Element 6 is the 2nd to last element, therefore removed. 
 * 
 * Input:k = 1,  2 -> 3 -> 5 -> X
 * Output: 2 -> 3 -> X
 ****************************************************************************************/
public class RemoveKthToLastElement {
    public ListNode removeKthToLast(ListNode head, int k)
    {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode right = dummy.next;
        
        while(k>0)
        {
            right = right.next;
            k--;
        }

        ListNode left = dummy;
        while(right != null)
        {
            left = left.next;
            right = right.next;
        }
        left.next = right;

        return dummy.next;
    }
}