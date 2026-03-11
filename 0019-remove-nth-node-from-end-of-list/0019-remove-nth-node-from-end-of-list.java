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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;
        // move ptr2 'n' spaces ahead
        for(int i = 0; i < n; i++){
            ptr2 = ptr2.next;
        }
        // We need to move both ptrs till we get the next of ptr2 as null
        while(ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // we have to delete the next node of the ptr1
        ptr1.next = ptr1.next.next;
        return dummy.next;
    }
}