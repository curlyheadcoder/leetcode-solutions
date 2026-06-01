class Solution {
    public int minimumCost(int[] cost) {
        // pick the candies with higher cost
        // so that you can take a free candy of higher cost as well
        // Sort the given array (descending order)
        Arrays.sort(cost);
        // skip every third candy so that you can get if for free
        // 2  --> 5 --> 8 --> 11
        int n = cost.length;
        int total = 0;
        for(int i = n-1; i >= 0; i--){
            if((n - 1 - i) % 3 != 2){
                total += cost[i];
            }
        }
        return total;
    }
}