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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode current = head;

        while (current != null) {
            st.push(current);
            current = current.next;
        }

        current = st.pop();
        int maximum = current.val;
        ListNode resultHead = new ListNode(maximum);

        while (!st.empty()) {
            current = st.pop();
            if (current.val < maximum) {
                continue;
            }
            else {
                ListNode newNode = new ListNode(current.val);
                newNode.next = resultHead;
                resultHead = newNode;
                maximum = current.val;
            }
        }

        return resultHead;
    }
}