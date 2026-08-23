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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        int expectedSize = 1;

        while (prevGroup.next != null) {

            // Find actual size of current group
            int actualSize = 0;
            ListNode curr = prevGroup.next;

            while (actualSize < expectedSize && curr != null) {
                actualSize++;
                curr = curr.next;
            }

            // curr is the node after the current group
            ListNode groupNext = curr;

            // Reverse only if actual size is even
            if (actualSize % 2 == 0) {

                ListNode prev = groupNext;
                curr = prevGroup.next;

                while (curr != groupNext) {
                    ListNode next = curr.next;

                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                // Connect previous part to reversed group
                ListNode oldFirst = prevGroup.next;

                prevGroup.next = prev;

                // oldFirst is now the last node
                prevGroup = oldFirst;

            } else {

                // Group wasn't reversed.
                // Move prevGroup to the last node of this group.
                for (int i = 0; i < actualSize; i++) {
                    prevGroup = prevGroup.next;
                }
            }

            expectedSize++;
        }

        return dummy.next;
    }
}