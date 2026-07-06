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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = head;

        while (temp != null) {

            if (p2 != null) {
                p2 = p2.next;
            }

            k--;

            if (k == 0) {
                p1 = temp;
                p2 = head;
            }

            temp = temp.next;
        }

        // Swap the values of the two nodes
        int val = p1.val;
        p1.val = p2.val;
        p2.val = val;

        return head;
    }
}