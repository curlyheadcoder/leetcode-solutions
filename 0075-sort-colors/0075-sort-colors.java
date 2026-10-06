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
    private void swap(int [] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}