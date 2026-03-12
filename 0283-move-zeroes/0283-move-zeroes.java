class Solution {
    public void moveZeroes(int[] nums) {
        int insertIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[insertIdx] = nums[i];
                insertIdx++;
            }
        }
        while(insertIdx < nums.length){
            nums[insertIdx] = 0;
            insertIdx++;
        }
    }
}