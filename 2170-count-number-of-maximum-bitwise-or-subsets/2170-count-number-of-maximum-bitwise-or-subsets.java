class Solution {
    private int countSubsets(int idx, int currOr, int[] nums, int maxOr){
        // base case
        if(idx == nums.length){
            if(currOr == maxOr){
                return 1; // found one subset
            }
            return 0;
        }
        // Take nums[idx]
        int takeCount = countSubsets(idx+1, currOr | nums[idx], nums, maxOr);
        // Not taking nums[idx]
        int notTakeCount = countSubsets(idx+1, currOr, nums, maxOr);

        return takeCount + notTakeCount;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num : nums){
            maxOr |= num;
        }

        int currOr = 0;
        return countSubsets(0, currOr, nums, maxOr);
    }
}