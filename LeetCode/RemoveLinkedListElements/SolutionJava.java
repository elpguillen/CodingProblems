/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        
        ListNode prevNode = null;
        ListNode currNode = head;
        
        while (currNode != null) {
            if (currNode.val == val) {
                if (currNode == head) {
                    currNode = currNode.next;
                    head = currNode;
                } else if (currNode.next == null) {
                    prevNode.next = null;
                    currNode = null;
                } else {
                    prevNode.next = currNode.next;
                    currNode = currNode.next;
                }
                
            } else {
                prevNode = currNode;
                currNode = currNode.next;
            }
    
        }
        
        return head;
    }
}