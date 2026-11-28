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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left + (right - left)/2;
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid+1, right);

        return mergeTwoLists(leftList, rightList);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode list3 = new ListNode(0);
        ListNode l3 = list3;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if(l1 != null){
            l3.next = l1;
        }else if(l2 != null){
            l3.next = l2;
        }
        return list3.next;
    }
}
