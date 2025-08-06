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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // Travel until the fast pointer reaches the last node or null
        while(fast != null && fast.next != null){
            // slow pointer moves 1 node at a time
            slow = slow.next;
            // fast pointer moves 2 nodes at a time
            fast = fast.next.next;
        }
        return slow;
    }
}