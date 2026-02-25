class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum = sum + nums[right];
            while(sum >= target){
                int len = right - left + 1;
                if(len < minLen){
                    minLen = len;
                }
                sum = sum - nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}