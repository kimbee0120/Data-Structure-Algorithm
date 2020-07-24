/***************************************************************
 * Given a singly linked list, reorder its nodes such that pairs
 *  of consecutive nodes are interchanged. 
 * 
 * Input:  'a' -> 'b' -> 'c' -> 'd' -> 'e' -> 'f' -> X
 * Output: 'b' -> 'a' -> 'd' -> 'c' -> 'f' -> 'e' -> X
 **************************************************************/

public class SwapLinkedListNode{
    public ListNode swapInPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode secondSeg = null;

        head = head.next; //when you return head, it should place from second pointer

        while(true){
            secondSeg = second.next;
            second.next = first;

            if(secondSeg == null || secondSeg.next == null){
                first.next = secondSeg;
                return head;
            }

            first.next = secondSeg.next;
            first = secondSeg;
            second = secondSeg.next;
        }
    }
}

//Time Complexity = O(n);
//Space Complexity = O(1);