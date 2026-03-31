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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode node = new ListNode(0);
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            ListNode prev = node;
            while(prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = temp;
        }
        return node.next;
    }
}
