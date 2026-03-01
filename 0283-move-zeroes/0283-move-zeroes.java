class Solution {
    public void moveZeroes(int[] nums) {
        // start with first postion
        int insertPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        while(insertPos < nums.length){
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}