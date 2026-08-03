class Solution {

    int Alice = 1;
    int Bob = 0;
    int n;

    public int miniMax(int[] stoneValue, int player, int i, int[][] dp) {

        if (i >= n)
            return 0;

        if (dp[player][i] != Integer.MIN_VALUE)
            return dp[player][i];

        int result = (player == Alice) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int stones = 0;

        for (int j = i; j < Math.min(i + 3, n); j++) {

            if (player == Alice) {
                stones += stoneValue[j];
                result = Math.max(result,
                        stones + miniMax(stoneValue, Bob, j + 1, dp));
            } else {
                stones -= stoneValue[j];
                result = Math.min(result,
                        stones + miniMax(stoneValue, Alice, j + 1, dp));
            }
        }

        dp[player][i] = result;
        return result;
    }

    public String stoneGameIII(int[] stoneValue) {

        n = stoneValue.length;

        int[][] dp = new int[2][n + 1];

        for (int i = 0; i < 2; i++) {
            java.util.Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int diff = miniMax(stoneValue, Alice, 0, dp);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }
}