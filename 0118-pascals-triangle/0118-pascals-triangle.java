class Solution {
    public List<List<Integer>> generate(int numRows) {
        /* Using Combinations (nCr Formula)
            Each element at index j in row i is C(i, j): C(n, r) = n!/(r! * (n-r)!)
            We can precompute factorials or use iterative formula to compute 
            C(i, j) efficiently without recomputing
        */
        List<List<Integer>> res = new ArrayList<>();
        for(int n = 0; n < numRows; n++){
            List<Integer> row = new ArrayList<>();
            int val = 1;     // C(n,0) is always 1
            for(int k = 0; k <= n; k++){
                row.add(val);
                // Compute next value using the property
                // C(n , k+1) = C(n,k) * (n-k)/(k+1)
                val = val * (n - k) / (k + 1);
            }
            res.add(row);
        }
        return res;
    }
}