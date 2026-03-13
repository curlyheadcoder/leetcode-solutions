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
        Stack<Integer> st = new Stack<>();
        while(head != null){
            st.push(head.val);
            head = head.next;
        }
        ListNode rev = new ListNode(0);
        ListNode dummy = rev;
        while(!st.isEmpty()){
            dummy.next = new ListNode(st.pop());
            dummy = dummy.next;
        }
        return rev.next;
    }
}