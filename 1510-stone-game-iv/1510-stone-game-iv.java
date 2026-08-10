class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[0] = false
        // No stones means the player whose turn it is loses.

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                // If we can leave a losing position
                // for the opponent, we win.
                if (dp[i - square] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}