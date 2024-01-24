/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Determines whether or not there is a cycle in a linked list.
     * 
     * @param head  the head of a linked list
     * @return      true if cycle present in linked list, false otherwise
     */
    public boolean hasCycle(ListNode head) {

        // Case: linked list is empty or linked list
        //       has one node but does not point to itself
        //       thus no cycle present
        if (head == null || head.next == null)
            return false;

        // Case: linked list has only one node that points to itself
        //       thus cycle present
        if (head.next == head)
            return true;

        // slow pointer will move ahead by one and fast pointer
        // will move ahead by two, thereby making it so that if
        // a cycle is present the two pointers will meet
        ListNode slowPointer = head;
        ListNode fastPointer  = head.next;

        while (fastPointer != null) {
            
            if (slowPointer == fastPointer) {
                return true;
            }

            if (fastPointer.next == null)
                return false;
            
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return false;
    }
}