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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode currNode = head;
        ArrayList<Integer> values = new ArrayList<>();
        
        while (currNode != null) {
            values.add(currNode.val);
            currNode = currNode.next;
        }
        
        int numValues = values.size();
        ListNode reversed = new ListNode(values.get(numValues - 1));
        ListNode nextNode = null;
        currNode = reversed;
        
        for (int i = numValues - 2; i > -1; i--) {
            nextNode = new ListNode(values.get(i));
            currNode.next = nextNode;
            currNode = nextNode;
        }
                
        return reversed;
    }
}/**
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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode currNode = head;
        ArrayList<Integer> values = new ArrayList<>();
        
        while (currNode != null) {
            values.add(currNode.val);
            currNode = currNode.next;
        }
        
        int numValues = values.size();
        ListNode reversed = new ListNode(values.get(numValues - 1));
        ListNode nextNode = null;
        currNode = reversed;
        
        for (int i = numValues - 2; i > -1; i--) {
            nextNode = new ListNode(values.get(i));
            currNode.next = nextNode;
            currNode = nextNode;
        }
                
        return reversed;
    }
}