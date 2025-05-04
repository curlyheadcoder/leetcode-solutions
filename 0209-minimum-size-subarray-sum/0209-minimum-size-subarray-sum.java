class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, low = 0, high = 0;
        int minLenWindow = Integer.MAX_VALUE;;
        for(high = 0; high < nums.length; high++){
            sum += nums[high];
            while(sum >= target){
                int currWindow = high - low + 1;
                minLenWindow = Math.min(minLenWindow, currWindow);
                sum = sum - nums[low];
                low++;
            }
        }
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}