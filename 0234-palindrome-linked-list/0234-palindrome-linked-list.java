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
    private ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return helper(head);
    }
    private boolean helper(ListNode node){
        if(node == null) return true;

        boolean isPal = helper(node.next);
        if(!isPal) return false;

        boolean isEqual = (node.val == front.val);
        front= front.next;
        return isEqual;
    }
}