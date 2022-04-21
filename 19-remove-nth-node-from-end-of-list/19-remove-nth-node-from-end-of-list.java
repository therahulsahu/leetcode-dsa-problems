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
    // one pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = new ListNode(0);
        ListNode fast = slow, dummy = slow;
        slow.next = head;
        
        // move fast n + 1 ahead
        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}