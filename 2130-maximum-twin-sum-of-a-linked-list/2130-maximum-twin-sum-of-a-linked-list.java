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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int i=0,j=arr.size()-1;
        int maxsum=0;
        while(i<j){
            int sum=arr.get(i)+arr.get(j);
            if(sum>maxsum){
                maxsum=sum;
            }
            i++;
            j--;
        }
        return maxsum;

    }
}