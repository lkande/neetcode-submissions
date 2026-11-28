/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;
        Node l1 = head;
        do {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        } while(l1 != null);
        l1 = head;
        do {
            if (l1.random != null) {
                l1.next.random =  l1.random.next;
            }
            l1 = l1.next.next;
        } while(l1 != null);
        l1 = head;
        Node newhead = head.next;
        do {
            Node l2 = l1.next;
            l1.next = l2.next;
            l1 = l1.next;
            if(l1 != null) {
                l2.next = l1.next;
            }
        } while(l1 != null);
        return newhead;        
    }
}
