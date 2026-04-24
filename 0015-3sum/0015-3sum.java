class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // we want to use Two Pointers 
        // we will do sorting first
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                // Two Sum II
                twoSum(nums, i, triplets);
            }
        }
        return triplets;
    }
    private void twoSum(int [] nums, int i, List<List<Integer>> triplet){
        int left = i+1, right = nums.length-1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                triplet.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while(left < right && nums[left] == nums[left-1]){
                    left++;        // duplicate found (skip)
                }
            }else if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
    }
}