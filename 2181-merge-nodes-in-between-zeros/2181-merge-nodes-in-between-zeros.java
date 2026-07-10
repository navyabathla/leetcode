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
    public ListNode mergeNodes(ListNode head) {
        ListNode P1 = head.next;
        ListNode P2 = P1;
        
        while (P2 != null) {
            int sum = 0;
            while (P2 != null && P2.val != 0) {
                sum += P2.val;
                P2 = P2.next;
            }
            
            P1.val = sum;
            P2 = P2.next;
            P1.next = P2;
            P1 = P1.next;
        }
        
        return head.next;
    }
}