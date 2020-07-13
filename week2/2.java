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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int add = 0;
        int l = 0, r = 0;
        while (l1 != null || l2 != null) {
            l = l1 == null ? 0 : l1.val;
            r = l2 == null ? 0 : l2.val;
            int sum = l + r + add;
            add = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (add == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    // Time = O(m + n)
    // Space = O(1)
}