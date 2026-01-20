class Solution {
    public int binaryRec(int [] nums, int target, int st, int end){
        if(st > end) return -1;
        int mid = st + (end - st) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binaryRec(nums, target, st, mid-1);
        else return binaryRec(nums, target, mid+1, end);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        return binaryRec(nums, target, 0, n-1);
    }
}