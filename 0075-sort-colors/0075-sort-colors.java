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
    public void swap(int [] nums, int n1, int n2){
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}