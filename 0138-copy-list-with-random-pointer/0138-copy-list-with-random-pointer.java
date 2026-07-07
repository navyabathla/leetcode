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
        if (head == null) {
            return null;
        }

        // Step 1: Create copy nodes and insert them after original nodes
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;

            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = nextNode;

            curr = nextNode;
        }

        // Step 2: Assign random pointers to copied nodes
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and copied linked lists
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;

        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;      // Restore original list
            copyCurr.next = copy;       // Build copied list
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }
}