class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Brute Force -> G.A.S. (Generate All Subarrays)
        if(k <= 1) return 0;
        int count = 0, start = 0, end = 0, prod = 1, n = nums.length;  
        while(end < n){
            prod *= nums[end];    // expand
            while(prod >= k){
                prod /= nums[start];   // shrink
                start++;
            }
            count += (end - start + 1);
            end++;
        }

        return count;
    }
}