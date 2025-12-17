class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long count = 1, res = 1;
        // since first one is a smooth descent period itself
        for(int i = 1; i < n; i++){
            if(prices[i-1] - prices[i] == 1){
                count++;
            }else{
                count = 1;
            }
            res += count;
        }
        return res;
    }
}