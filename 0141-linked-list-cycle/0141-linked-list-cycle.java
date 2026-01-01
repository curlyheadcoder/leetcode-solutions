/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode sp = head, fp = head;
        while(sp != null && fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;
            if(sp == fp) return true;
        }
        return false;
    }
}