class Solution {
    public long minArraySum(int[] nums, int k) {
        int n = nums.length;
        long total = 0;
        for(int x : nums) total += x;

        long dpPrev = 0L;     // dp[0] = 0
        long prefix = 0L;     // P[i]

        // best[r] = max over indices a with R[a] == r of (dp[a] - P[a])
        final long NEG_INF = Long.MIN_VALUE/4;    // safe sentinal
        long [] best = new long [k];
        Arrays.fill(best, NEG_INF);
        // initial state: P[0] = 0, R[0] = 0, dp[0] - P[0] = 0
        best[0] = 0L;

        for(int i = 1; i <= n; ++i){
            prefix += nums[i-1];
            int r = (int)(prefix % k);
            if(r < 0) r += k;

            // option 1: don't take any new interval ending at i -> dp[i] = dp[i-1]
            long dpi = dpPrev;

            // option 2: take best earlier a with same remainder -> best[r] + P[i]
            if(best[r] != NEG_INF){
                long candidate = best[r] + prefix;
                if(candidate > dpi) dpi = candidate;
            }

            // update best for remainder r using dp[i] - P[i]
            long valForBest = dpi - prefix;
            if(valForBest > best[r]) best[r] = valForBest;

            dpPrev = dpi;
        }

        long maxDeleted = dpPrev;
        return total - maxDeleted;
    }
}