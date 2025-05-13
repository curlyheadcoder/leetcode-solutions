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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
    private TreeNode buildBST(int [] nums, int left, int right){
        // Base Case: Agar left > right ho gaya toh koi node nahi hogi
        if(left > right) return null;
        // Middle element choose karo
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // Left aur right  subtree recursively build karo
        node.left = buildBST(nums, left, mid-1);
        node.right = buildBST(nums, mid+1, right);

        return node;
    }
}