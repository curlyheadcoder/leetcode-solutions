class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean containsOne = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                containsOne = true;
            }
            if(nums[i] > n || nums[i] <= 0){
                nums[i] = 1;
            }
        }
        if(containsOne == false){
            return 1;
        }
        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
}