class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int MOD = 1_000_000_007; // fixed modulus

        // Get powers of 2 present in 'n'
        int p = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                list.add(p);
            }
            n >>= 1;
            p <<= 1;
        }

        // list now has powers in increasing order, as required
        int m = list.size();
        int[][] res = new int[m][m];

        // Precompute products modulo MOD
        for (int i = 0; i < m; i++) {
            long curr = 1;
            for (int j = i; j < m; j++) {
                curr = (curr * list.get(j)) % MOD;
                res[i][j] = (int) curr;
            }
        }

        // Process queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = res[queries[i][0]][queries[i][1]];
        }

        return ans;
    }
}
