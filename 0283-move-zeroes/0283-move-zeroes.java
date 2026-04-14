class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
        }    // 1 3 12 3 12     THis is done till now
        // we have to update last two 3 , 12 to zeroes 
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}