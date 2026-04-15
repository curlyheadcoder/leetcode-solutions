class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long currSum = 0, maxSum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            while(set.contains(nums[right]) || set.size() == k){
                set.remove(nums[left]);
                currSum = currSum - nums[left];
                left++;
            }
            currSum = currSum + nums[right];
            set.add(nums[right]);
            if(set.size() == k){
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }
}