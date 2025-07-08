class Solution {
    private int [][] dp;
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        int [][] dp = new int[k+1][n];
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for(int currIndex = n - 1; currIndex >= 0; currIndex--){
            for(int count = 1; count <= k; count++){
                int nextIndex = bisectRight(events, events[currIndex][1]);
                int take = events[currIndex][2];
                if (nextIndex < n) {
                    take += dp[count - 1][nextIndex];
                }
            int skip = (currIndex + 1 < n) ? dp[count][currIndex + 1] : 0;

            dp[count][currIndex] = Math.max(skip, take);

            }
        }
        return dp[k][0];
    }
    // private int dfs(int currIndex, int count, int [][] events){
    //     if(count == 0 || currIndex == events.length){
    //         return 0;
    //     }
    //     if(dp[count][currIndex] != -1){
    //         return dp[count][currIndex];
    //     }
    //     int nextIndex = bisectRight(events, events[currIndex][1]);
    //     dp[count][currIndex] = Math.max(dfs(currIndex+1, count, events), events[currIndex][2] + dfs(nextIndex, count - 1, events));
    //     return dp[count][currIndex];
    // }
    private static int bisectRight(int [][] events, int target){
        int left = 0, right = events.length;
        while(left < right){
            int mid = (left + right)/ 2;
            if(events[mid][0] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}