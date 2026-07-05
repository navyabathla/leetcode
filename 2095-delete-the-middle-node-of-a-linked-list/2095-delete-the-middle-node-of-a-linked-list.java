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
    private int getSize(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
   
    public ListNode deleteMiddle(ListNode head) {
        // If there is only one node
        if (head == null || head.next == null) {
            return null;
        }

        int n = getSize(head);
        int middle = n / 2;

        ListNode curr = head;
        ListNode prev = null;

        for (int i = 0; i < middle; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Delete the middle node
        prev.next = curr.next;

        return head;
    }
    

}
   
    