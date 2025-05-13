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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Base case: agar head null hai toh BST bhi null hoga
        if(head == null) return null;
        // Base case: agar sirf ek hi node hai, wahi root ban jayega
        if(head.next == null) return new TreeNode(head.val);
        // Slow-Fast pointer se middle element nikaalte hai
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        // Slow middle pe aayega, fast end tak jaayega
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        } 
        // Left part ko tod dete hai
        if(prev != null) prev.next = null;
        // Middle element root banega 
        TreeNode root = new TreeNode(slow.val);
        // Recursively left aur right subtree banate hai
        root.left = sortedListToBST(head == slow ? null : head);  
        // Agar head == slow,  toh left part nahi hai
        root.right = sortedListToBST(slow.next);

        return root;
    }
}