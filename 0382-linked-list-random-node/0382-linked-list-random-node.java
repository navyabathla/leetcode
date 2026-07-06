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

    private ListNode head;
    private Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    public int getRandom() {
        int result = 0;
        int size = 1;

        ListNode curr = head;

        while (curr != null) {

            if (random.nextInt(size) == 0) {
                result = curr.val;
            }

            curr = curr.next;
            size++;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */