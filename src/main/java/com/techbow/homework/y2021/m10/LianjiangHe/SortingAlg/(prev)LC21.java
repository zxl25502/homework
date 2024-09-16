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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1);
        ListNode temp = curr;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
                //  curr.next.next = temp;
            }else{
                temp.next = l2;
                l2 = l2.next;
                //  curr.next.next = temp;
            }

            temp = temp.next;
            // curr.next = l1;
            // curr.next.next = l2;
            // l1 = l1.next;
            // l2 = l2.next;
            // curr.next.next.next  = temp;

        }
        temp.next = l1 == null ? l2 : l1;
        return curr.next;
    }

}