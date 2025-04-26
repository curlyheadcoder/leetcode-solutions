class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int skip = -1, minIdx = -1, maxIdx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK) skip = i;
            if(nums[i] == minK) minIdx = i;
            if(nums[i] == maxK) maxIdx = i;
            ans += Math.max(0L, Math.min(minIdx, maxIdx) - skip);
        }
        return ans;
    }
}