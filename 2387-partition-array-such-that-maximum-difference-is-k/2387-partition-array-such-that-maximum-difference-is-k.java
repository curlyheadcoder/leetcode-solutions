class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);   // Step 1: sort the array
        int count = 1;   // Atleast one subsequence is needed
        int start = nums[0];  // Start of the first subsequence 
        for(int num : nums){
            if(num - start > k){
                count++;  // Start a new subsequence
                start = num;    // Reset the start for the new subsequence
            } 
        }
        return count;
    }
}