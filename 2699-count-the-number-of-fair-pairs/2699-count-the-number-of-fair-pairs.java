class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int low = lower - nums[i];
            int high = upper - nums[i];
            int left = binarySearchLeft(nums, i+1, nums.length - 1, low);
            int right = binarySearchRight(nums, i+1, nums.length - 1, high);
            if(left != -1 && right != -1){
                count += (right - left + 1);
            }
        }
        return count;
    }
    private int binarySearchLeft(int [] nums, int start, int end, int target){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                res = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }
    private int binarySearchRight(int [] nums, int start, int end, int target){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target){
                res = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }
}