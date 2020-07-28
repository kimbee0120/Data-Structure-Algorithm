import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

/*****************************************************************
 * Merge sort satisfies the recurrence T(n) = 2T(n/2) + O(n). 
 * Consequently, it bounds to the order of O(n * log(n)) for time.
 *****************************************************************/
public class MergeSort {
    public ListNode mergeSort(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode middle = halfListNode(head);
        
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middle);

        return sortNodeList(left, right);
    }

    private ListNode sortNodeList(ListNode leftp, ListNode rightp)
    {
        ListNode dummyhead = new ListNode(0);
        ListNode dummy = dummyhead;

        while(leftp != null || rightp != null)
        {
            if(leftp.val < rightp.val){
                dummy.next = leftp;
                leftp = leftp.next;
            }else {
                dummy.next = rightp;
                rightp = rightp.next;
            }
            dummy = dummy.next;
        }

        if(leftp != null){
            dummy.next = leftp;
        }

        if(rightp != null){
            dummy.next = rightp;
        }

        return dummyhead.next;
    }

    private ListNode halfListNode(ListNode head)
    {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
}