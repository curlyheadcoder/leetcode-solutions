class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        // Step 1: Initialize totalSum, positiveGainCount and minGainLoss
        long totalSum = 0;
        int positiveGainCount = 0;
        int minGainLoss = Integer.MAX_VALUE;

        // Step 2: Iterate over all nodes and calculate gains
        for(int num : nums){
            int xorValue = num ^ k;
            int gain = xorValue - num;
            // Add original value to the total
            totalSum += num;

            // Step 3: If gain is positive, it's a candidate for XOR
            if(gain > 0){
                totalSum += gain;  // Add the benefit of XOR
                positiveGainCount++;
            }
            // Track the minimum absolute gain (used if we need to skip one)
            minGainLoss = Math.min(minGainLoss, Math.abs(gain));
        }
        // Step 4: If count of gainful nodes is odd, drop the smallest gain
        if(positiveGainCount % 2 != 0){
            totalSum -= minGainLoss;
        }
        // Step 5: Return the final optimized sum
        return totalSum;
    }
}