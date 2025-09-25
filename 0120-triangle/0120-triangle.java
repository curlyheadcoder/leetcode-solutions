class Solution {
    List<List<Integer>> triangle;
    int m;
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        m = triangle.size();
        dp = new Integer[m][m];
        return sol(0, 0);
    }

    private int sol(int r, int c) {
        if (r == m) return 0;
        if (dp[r][c] != null) return dp[r][c];

        return dp[r][c] = triangle.get(r).get(c)
                + Math.min(
                sol(r + 1, c),
                sol(r + 1, c + 1)
        );
    }

    // Bottom-up with O(n) space
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1]; // extra element for dp[c+1] safety

        // Start from last row
        for (int r = n - 1; r >= 0; r--) {
            for (int c = 0; c < triangle.get(r).size(); c++) {
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c], dp[c + 1]);
            }
        }

        return dp[0];
    }
}