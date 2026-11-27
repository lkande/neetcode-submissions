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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode();
        dum.next = head;
        ListNode cn = dum;
        for(int i = 0; i < n && cn != null; i++) {
            cn = cn.next;
        }
        if (cn == null) {
            return head;
        }
        ListNode c = dum;
        while(cn.next != null) {
            c = c.next;
            cn = cn.next;
        }
        c.next = c.next.next;
        return dum.next;
    }
}
