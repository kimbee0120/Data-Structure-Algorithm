/********************************************************************************
* Given a singly linked list, arrange the nodes such that all even 
* index nodes appear before the odd index nodes.

* When we refer to "index" we are referring to the node's zero-indexed 
* position in the input (original) list.

* The relative ordering of the nodes within the same region must be maintained.
********************************************************************************/
public class EvenOddPartition
{
    public ListNode evenOddPartition(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddhead = odd;

        while(odd != null && odd.next != null)
        {
            even.next = odd.next;
            even = even.next;

            odd.next = even.next;
            odd = odd.next;
        }

        even.next = oddhead;

        return head;

    }
}