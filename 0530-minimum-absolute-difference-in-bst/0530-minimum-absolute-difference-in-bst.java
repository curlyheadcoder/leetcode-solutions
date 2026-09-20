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
    
    private int minDiff = Integer.MAX_VALUE;
    
    private Integer prevVal = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;    
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prevVal != null){
            minDiff = Math.min(minDiff, node.val - prevVal);
        }
        prevVal = node.val;
        inorder(node.right);
    }
}














