class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] != nums[k]){
                nums[k+1] = nums[i];
                k++;
            }
        }
        return k+1;
    }
}