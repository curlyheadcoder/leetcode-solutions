class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    private void swap(int [] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}