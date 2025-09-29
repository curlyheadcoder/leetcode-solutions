class Solution {
    public int minScoreTriangulation(int[] values) {
         int n = values.length;
    int[][] dp = new int[n][n];

    for (int len = 3; len <= n; len++) { // length of subpolygon
        for (int i = 0; i + len <= n; i++) {
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                dp[i][j] = Math.min(
                    dp[i][j],
                    dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]
                );
            }
        }
    }
    return dp[0][n - 1];
    }
}