class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;    
    }

    private void quickSort(int [] nums, int low, int high){
        if(low < high){
            int p = partition(nums, low, high);
            quickSort(nums, low, p);
            quickSort(nums, p+1, high);
        }
    }
    private int partition(int [] nums, int low, int high){
        int pivot = nums[low];
        int i = low-1;
        int j = high+1;
        while(true){
            // move i to the right
            do{
                i++;
            }while(nums[i] < pivot);
            // move j to left
            do{
                j--;
            }while(nums[j] > pivot);

            if(i >= j){
                return j;
            }
            swap(nums, i, j);
        }
    }
    private void swap(int [] nums, int ptr1, int ptr2){
        int temp = nums[ptr1];
        nums[ptr1] = nums[ptr2];
        nums[ptr2] = temp;
    }
}