class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid = 0;

        while(mid <= right){
            if(nums[mid] == 0){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }else{
                mid++;
            }
        }
    }
}
//     private static void swap(int [] nums, int pos1, int pos2){
//         int temp = nums[pos1];
//         nums[pos1] = nums[pos2];
//         nums[pos2] = temp;
//     }
// }