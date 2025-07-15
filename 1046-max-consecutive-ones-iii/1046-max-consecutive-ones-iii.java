class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeroCount = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            // If zeroCount exceeds k, shrink the window
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }
}