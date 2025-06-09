class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        while(k > 1){
            long nodes = countNodesInTree(curr, n);
            if(nodes >= k){
                k--;
                curr *= 10;
            }else{
                k -= nodes;
                curr++;
            }
        }
        return (int)curr;
    }
    private long countNodesInTree(long root, int n){
        long curr = root;
        long next = curr + 1;
        long res = 0;
        while(curr <= n){
            res += Math.min(n - curr + 1, next - curr);
            curr *= 10;
            next *= 10;
        }
        return res;
    }
}