class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int end = 0; end < nums.length; end++){
            sum += nums[end];
            while(sum >= target){
                int len = end - start + 1;
                if(len < minLen){
                    minLen = len;
                }
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}