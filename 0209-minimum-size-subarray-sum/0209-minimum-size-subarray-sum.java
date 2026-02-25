class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                int len = right - left + 1;
                if(len < minLen){
                    minLen = len;
                }
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}