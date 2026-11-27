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
        int i = 0;
        while(i < n && cn != null) {
            cn = cn.next;
            i++;
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
