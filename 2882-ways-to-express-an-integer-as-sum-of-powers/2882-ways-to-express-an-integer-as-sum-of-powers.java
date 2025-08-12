class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        // Precompute all powers ≤ n
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; ; i++) {
            long p = fastPow(i, x);
            if (p > n) break;
            powers.add((int) p);
        }

        // dp[i] = number of ways to make sum i
        int[] dp = new int[n + 1];
        dp[0] = 1; // base case

        // For each power, update the dp table
        for (int p : powers) {
            for (int sum = n; sum >= p; sum--) {
                dp[sum] = (dp[sum] + dp[sum - p]) % MOD;
            }
        }

        return dp[n];
    }

    // Integer fast exponentiation to avoid floating point errors
    private long fastPow(int base, int exp) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) result *= b;
            b *= b;
            exp >>= 1;
        }
        return result;
    }
}
