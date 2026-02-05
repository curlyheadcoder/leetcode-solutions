class Solution {
    public void sortColors(int[] nums) {
        /*
                0  ---> red       -----> start
                1  ---> white     -----> middle
                2  ---> blue      -----> at end 
                expected  --> 0 0 0 1 1 1 2 2 
        */


        int start = 0, end = nums.length-1;
        int mid = 0;
        while(mid <= end){
            if(nums[mid] == 0){
                swap(nums, start, mid);
                start++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, mid, end);
                end--;
            }else{
                mid++;
            }
        }
        
    }
    public void swap(int [] nums, int pos1, int pos2){
            int temp = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = temp;
        }
}