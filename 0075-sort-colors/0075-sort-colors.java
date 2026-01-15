class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid = 0;
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums, left, mid);
                left++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, mid, right);
                right--;
            }else{
                mid++;
            }
        }
    }
    private void swap(int [] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}