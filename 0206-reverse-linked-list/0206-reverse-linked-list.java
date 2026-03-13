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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> valStack = new Stack<>();
        while(head != null){
            valStack.push(head.val);
            head = head.next;
        }
        ListNode rev = new ListNode(0);
        ListNode ptr = rev;
        while(!valStack.isEmpty()){
            ptr.next = new ListNode(valStack.pop());
            ptr = ptr.next;
        }
        return rev.next;
    }
}