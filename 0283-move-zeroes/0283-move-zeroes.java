class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && nums[j] == 0){
                swap(nums, i, j);
            } 
            if(nums[j] != 0){
                j++;
            }
        }
    }
    private void swap(int [] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}