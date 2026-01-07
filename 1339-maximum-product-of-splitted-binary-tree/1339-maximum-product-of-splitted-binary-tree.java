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
    
    long max = 0;
    int MOD = 1000000007;
        
    public int maxProduct(TreeNode root) {
        long totalSum = getSum(root);
        findMax(root, totalSum);
        return (int)(max % MOD);   
    }
    private long getSum(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }
    private long findMax(TreeNode node, long totalSum){
        if(node == null){
            return 0;
        }
        long left = findMax(node.left, totalSum);
        long right = findMax(node.right, totalSum);

        long subTreeSum = node.val + left + right;
        long product = subTreeSum * (totalSum - subTreeSum);

        if(product > max){
            max = product;
        }
        return subTreeSum;
    }
}