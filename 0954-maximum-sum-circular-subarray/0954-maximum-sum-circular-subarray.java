class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // Step 1: Standard Kadane's to find max subarray sum (non - circular)
        int maxKadane = kadane(nums);

        // Step 2: Calculate total array sum 
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
            nums[i] = -nums[i];      // Invert elements
        }
        // Step 3: Kadane's on inverted array to find min subarray sum
        int maxInvertedKadane = kadane(nums);
        int circularMax = totalSum + maxInvertedKadane;

        // Step 4: Handle all negative cases
        if(circularMax == 0) return maxKadane;
        return Math.max(maxKadane, circularMax);
    }
    private int kadane(int [] arr){
        int n = arr.length;
        int maxSoFar = arr[0], curr = arr[0];
        for(int i = 1; i < n; i++){
            curr = Math.max(curr + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, curr);
        }
        return maxSoFar;
    }
}