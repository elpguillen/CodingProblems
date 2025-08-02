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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null && list2 == null)
            return null;
        
        ListNode list1Tail = list1;
        
        ListNode list1Pointer = list1;
        ListNode list2Pointer = list2;
        
        ListNode result = null;
        ListNode nextNode = null;
        ListNode resultTail = null;
        
        int nextVal;
        
        while (list1Pointer != null && list2Pointer != null) {
            int list1Item = list1Pointer.val;
            int list2Item = list2Pointer.val;
            
            if (list1Item > list2Item) {
                nextVal = list2Item;
                list2Pointer = list2Pointer.next;
            } else {
                nextVal = list1Item;
                list1Pointer = list1Pointer.next;
            }
            
            nextNode = new ListNode(nextVal);
            
            if (result == null) {
                result = nextNode;
                resultTail = result;
            } else {
                resultTail.next = nextNode;
                resultTail = resultTail.next;
            }
        }
        
        while (list1Pointer != null) {
            nextNode = new ListNode(list1Pointer.val);
            
            if (result == null) {
                result = nextNode;
                resultTail = result;
            } else {
                resultTail.next = nextNode;
                resultTail = resultTail.next;
            }
            list1Pointer = list1Pointer.next;
        }
        
        while (list2Pointer != null) {
            nextNode = new ListNode(list2Pointer.val);
            
            if (result == null) {
                result = nextNode;
                resultTail = result;
            } else {
                resultTail.next = nextNode;
                resultTail = resultTail.next;
            }
            list2Pointer = list2Pointer.next;
        }
         
        return result;
    }
}