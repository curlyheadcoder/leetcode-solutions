class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i - 1);

            // Single digit
            if (current >= '1' && current <= '9') {
                dp[i] += dp[i - 1];
            }

            // Two digits
            int twoDigits = Integer.parseInt(
                s.substring(i - 2, i)
            );

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}