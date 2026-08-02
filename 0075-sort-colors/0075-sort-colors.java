class Solution {
    public void sortColors(int[] nums) {
        int st = 0, end = nums.length-1;
        int mid = 0;
        while(mid <= end){
            if(nums[mid] == 0){
                swap(nums, st, mid);
                st++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, mid, end);
                end--;
            }else{
                mid++;
            }
        }
    }
    public void swap(int [] nums, int n, int m){
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}