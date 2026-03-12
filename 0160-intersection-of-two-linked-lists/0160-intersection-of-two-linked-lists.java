/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = findLength(headA);
        int n = findLength(headB);

        ListNode fp = headA, sp = headB;
        if(m < n){
            for(int i = 0; i < n-m; i++){
                sp = sp.next;
            }
        }else if(n < m){
            for(int i = 0; i < m-n; i++){
                fp = fp.next;
            }
        }
        return findSameNode(fp, sp);
    }
    private int findLength(ListNode head){
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    private ListNode findSameNode(ListNode fp, ListNode sp){
        while(fp != null && sp != null){
            if(fp == sp){
                return fp;
            }else{
                fp = fp.next;
                sp = sp.next;
            }
        }
        return null;
    }
}