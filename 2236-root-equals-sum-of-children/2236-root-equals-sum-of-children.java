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
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        return helper(root);
    }
    private boolean helper(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = root.left.val;
        }
        if(root.right != null){
            right = root.right.val;
        }
        return (root.val == left + right) && helper(root.left) && helper(root.right);
    }
}