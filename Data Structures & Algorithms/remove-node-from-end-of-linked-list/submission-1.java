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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int total = 0;
        while(curr != null){
            total++;
            curr = curr.next;
        }
        ListNode prev = null;
        curr = head;
        for(int i = 0; i < total - n && curr != null; i++){
            prev = curr;
            curr = curr.next;
        }

        if(prev == null){
            return head.next;
        }

        if(curr != null){
            prev.next = curr.next;
        }

        return head;
        
    }
}
