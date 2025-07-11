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
    public ListNode swapPairs(ListNode head) {
        /*
        prev -> first -> second -> next
        prev -> second -> first -> next
        */

        // Create a dummy node to make head swaps easier
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null){
            // Nodes to swap
            ListNode first = prev.next;
            ListNode second = first.next;
            
            // Swapping 
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to the next pair
            prev = first;
        }
        return dummy.next;

    }
}