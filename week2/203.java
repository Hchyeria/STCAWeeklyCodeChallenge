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
        if (head == null) return head;
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        
        cur.next = null;
        return dummy.next;
    }

    // Time = O(n)
    // Space = O(1)
}