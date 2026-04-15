class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long windowSum = 0;
        long ans = 0;
        int max = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] > max) max = nums[i];
        }
        int[] freq =  new int[max + 1];
        int distinct = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] == 0) distinct++;
            freq[nums[i]]++;
            windowSum += nums[i];
            if (i - j + 1 > k) {
                freq[nums[j]]--;
                if (freq[nums[j]] == 0) distinct--;
                windowSum -= nums[j];
                j++;
            }
            if (i - j + 1 == k && distinct == k){
                if (windowSum > ans) ans = windowSum;
            }
        }
        return ans;
    }
}