class Solution {
    static final int MOD = 1_000_000_007;
    Integer [][] memo;
    public int numberOfWays(int n, int x) {
        memo = new Integer[n+1][n+2];  // extra space for curr = n + 1
        return dfs(n, x, 1);
    }

    private int dfs(int remaining, int x, int curr){
        if(remaining == 0) return 1;
        if(remaining < 0 || curr > remaining) return 0;   // also prunes large curr
        if(curr > remaining) return 0;

        if(memo[remaining][curr] != null) return memo[remaining][curr];

        long power = (long) Math.pow(curr, x);
        if(power > remaining) return 0;
        
        // Option 1: Take current number
        int take = dfs(remaining - (int) power, x, curr + 1);
        // Option 2: Skip current number
        int skip = dfs(remaining, x, curr + 1);

        return memo[remaining][curr] = (int) ((take + skip) % MOD);
    }
}