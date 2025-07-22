class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxSum = 0, currSum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}