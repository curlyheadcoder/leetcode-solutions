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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Check whether current has duplicates
            if (current.next != null &&
                current.val == current.next.val) {

                // Skip every node with this value
                while (current.next != null &&
                       current.val == current.next.val) {
                    current = current.next;
                }

                // Skip the entire duplicate group
                prev.next = current.next;

            } else {
                // Current value is unique
                prev = current;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
