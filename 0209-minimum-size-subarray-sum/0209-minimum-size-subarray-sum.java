class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE;
        int n = nums.length;
        while(j < n){
            sum += nums[j];
            while(sum >= target){
                len = Math.min(j-i+1, len);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}