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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int sum =0;
        while(cur!=null){
            if(cur.val + sum == 0)dummy.next = cur.next;
            sum+=cur.val;
            cur = cur.next;
        }
        if(dummy.next!=null)dummy.next.next=removeZeroSumSublists(dummy.next.next);
        return dummy.next;
    }
}
