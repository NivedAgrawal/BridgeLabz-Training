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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        ListNode temp = head.next;
        while(temp!=null){
            while(!stack.isEmpty() && stack.peek()<temp.val){
                stack.pop();
            }
            stack.push(temp.val);
            temp = temp.next;
        }
        head=null;
        while(!stack.isEmpty()){
            int k = stack.pop();
            System.out.println(k);
            ListNode n = new ListNode(k);
            n.next = head;
            head = n;
        }
        return head;
    }
}
