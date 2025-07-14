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
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;  // Save next
            curr.next = prev;              // Reverse pointer
            prev = curr;                   // Move prev forward
            curr = nextNode;               // Move curr forward
        }
        return prev;             // New Head
    }

    public int getDecimalValue(ListNode head) {
        head = reverseList(head);
        int res = 0;
        int power = 0;
        while(head != null){
            if(head.val == 1) res += (int)Math.pow(2,power);
            power++;
            head = head.next;
        }
        return res;
    }
}