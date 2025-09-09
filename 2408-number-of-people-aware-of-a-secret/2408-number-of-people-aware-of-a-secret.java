class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long [] dp = new long [n + 1];
        dp[1] = 1;
        for(int day = 1; day <= n; day++){
            for(int shareDay = day + delay; shareDay < day + forget && shareDay <= n; shareDay++){
                dp[shareDay] = (dp[shareDay] + dp[day]) % MOD;
            }
        }
        long res = 0;
        for(int day = n - forget + 1; day <= n; day++){
            if(day >= 1){
                res = (res + dp[day]) % MOD;
            }
        }
        return (int) res;
    }
}