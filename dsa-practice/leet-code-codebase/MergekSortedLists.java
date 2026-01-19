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
        PriorityQueue<Integer> pq = new PriorityQueue<>();;
        for(ListNode list:lists){
            while(list!=null){
                int sub = list.val;
                pq.add(sub);
                list = list.next;
            }
        } 
        if(pq.isEmpty()) return null;
        ListNode head = new ListNode(pq.poll());
        ListNode current = head;
        while(!pq.isEmpty()){
            current.next = new ListNode(pq.poll());
            current=current.next;

        }
        return head;
    }
}
