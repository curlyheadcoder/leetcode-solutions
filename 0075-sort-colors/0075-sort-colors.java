class Solution {
    public void sortColors(int[] nums) {
        int st = 0, end = nums.length-1;
        int i = 0;
        while(i <= end){
            if(nums[i] == 0){
                swap(nums, st, i);
                st++;
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, end);
                end--;
            }else{
                i++;
            }
        }
    }
    void swap(int []nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}