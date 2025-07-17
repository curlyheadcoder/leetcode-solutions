class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int [][] dp = new int [n][k];
        int maxLen = 1;
        for(int i = 0; i < n; i++){
            // Initialize: each single element is a valid subsequence of length 1
            Arrays.fill(dp[i], 1);

            for(int j = 0; j < i; j++){
                int mod = (nums[i] + nums[j]) % k;
                // If we can extend the subsequence ending at j
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                maxLen = Math.max(maxLen, dp[i][mod]);
            }
        }
        return maxLen;
    }
}