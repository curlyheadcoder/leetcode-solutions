class Solution {
    final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize the DP table
        Pair<Long, Long>[][] t = new Pair[m][n];

        // Base case: starting point
        t[0][0] = new Pair<>((long) grid[0][0], (long) grid[0][0]);

        // Fill the first row
        for (int j = 1; j < n; j++) {
            t[0][j] = new Pair<>(t[0][j - 1].getKey() * grid[0][j], t[0][j - 1].getValue() * grid[0][j]);
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            t[i][0] = new Pair<>(t[i - 1][0].getKey() * grid[i][0], t[i - 1][0].getValue() * grid[i][0]);
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long upMax = t[i - 1][j].getKey();
                long upMin = t[i - 1][j].getValue();

                long leftMax = t[i][j - 1].getKey();
                long leftMin = t[i][j - 1].getValue();

                t[i][j] = new Pair<>(
                    Math.max(Math.max(upMax * grid[i][j], upMin * grid[i][j]), Math.max(leftMax * grid[i][j], leftMin * grid[i][j])),
                    Math.min(Math.min(upMax * grid[i][j], upMin * grid[i][j]), Math.min(leftMax * grid[i][j], leftMin * grid[i][j]))
                );
            }
        }

        // Get the result from the bottom-right corner
        long maxProd = t[m - 1][n - 1].getKey();

        // If the result is negative, return -1, otherwise return the result modulo MOD
        return maxProd < 0 ? -1 : (int) (maxProd % MOD);
    }
}