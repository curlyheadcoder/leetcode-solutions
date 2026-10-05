class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);
        // int left = 0, right = nums.length-1;
        
        for(int i = 0; i < nums.length; i++){
            
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                return new int [] {i, j};
                }
            }
        }
        return new int [] {-1, -1};
    }
}