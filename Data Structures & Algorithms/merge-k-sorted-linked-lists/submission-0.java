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
        if(lists.length < 1){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }

        int mid = left + (right - left)/2;

        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid + 1, right);

        return mergeTwoLists(leftList, rightList);
        
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode l3 = new ListNode(0);
        ListNode list3 = l3;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                list3.next = list1;
                list1 = list1.next;
            }else{
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }
        if(list1 != null){
            list3.next = list1;
        }else{
            list3.next = list2;
        }
        return l3.next;
    }
}
