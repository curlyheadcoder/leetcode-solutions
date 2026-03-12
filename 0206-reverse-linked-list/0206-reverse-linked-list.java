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
        Stack<Integer> valSt = new Stack<>();
        while(head != null){
            valSt.push(head.val);
            head = head.next;
        }
        ListNode revList = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = revList; 
        while(!valSt.isEmpty()){
            ptr.next = new ListNode(valSt.pop());
            ptr = ptr.next;
        }
        return revList.next;
    }
}