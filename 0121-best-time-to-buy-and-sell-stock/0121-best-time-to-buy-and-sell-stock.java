class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - min;
            if(profit > ans){
                ans = profit;
            }
            min = Math.min(prices[i], min);
        }
        return ans;
    }
}