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
    public ListNode sortList(ListNode head) {
        ListNode node = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(node!=null){
            list.add(node.val);
            node = node.next;
        }
        ListNode temp = head;
        Collections.sort(list);
        int i=0;
        while(temp!=null){
            temp.val = list.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
}
