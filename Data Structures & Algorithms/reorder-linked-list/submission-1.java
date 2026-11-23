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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        ListNode prev = slow.next = null;
        while(mid != null){
            ListNode node = mid.next;
            mid.next = prev;
            prev = mid;
            mid = node;
        }

        ListNode l1 = head;
        ListNode l2 = prev;

        while(l2 != null){
            ListNode node1 = l1.next;
            ListNode node2 = l2.next;
            l1.next = l2;
            l2.next = node1;
            l1 = node1;
            l2 = node2;
        }

    }
}
