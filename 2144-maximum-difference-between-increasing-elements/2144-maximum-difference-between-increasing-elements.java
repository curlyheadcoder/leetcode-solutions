class Solution {
    public int maximumDifference(int[] nums) {
        int minEle = nums[0];
        int maxDiff = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > minEle){
                maxDiff = Math.max(maxDiff, nums[i] - minEle);
            }else{
                minEle = nums[i];
            }
        }
        return maxDiff;
    }
}