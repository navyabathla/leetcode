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
    private int getSize(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        int n=getSize(head);
        int middle=n/2;
        for(int i=0;i<middle;i++){
            head=head.next;
        }
        return head;


    }
}