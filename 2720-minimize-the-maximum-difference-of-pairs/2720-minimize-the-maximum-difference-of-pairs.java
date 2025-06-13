class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length-1];
        int res = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canFormPairs(nums,p,mid)){
                res = mid;    // valid, try for a smaller max diff
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    private boolean canFormPairs(int [] nums, int p, int maxDiff){
        int count = 0;
        int i = 0;
        while(i < nums.length - 1){
            if(nums[i+1] - nums[i] <= maxDiff){
                count++;
                i += 2;    // skip next index to avoid overlap
            }else{
                i++;
            }
        }
        return count >= p;
    }
}