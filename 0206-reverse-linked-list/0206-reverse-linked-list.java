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
        ListNode ptr =rev;
        while(!st.isEmpty()){
            ptr.next = new ListNode(st.pop());
            ptr = ptr.next;
        }
        return rev.next;
    }
}