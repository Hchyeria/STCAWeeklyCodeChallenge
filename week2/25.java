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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k) {
            count++;
            cur = cur.next;
        }
        if (count == k) {
            ListNode pre = reverseKGroup(cur, k);
            
            while (count-- > 0) {
                ListNode nextNode = head.next;
                head.next = pre;
                pre = head;
                head = nextNode;
            }
            return pre;
        }
        return head;
    }
    
    // Time = O(n)
    // Space = O(n / k), call-stack
}