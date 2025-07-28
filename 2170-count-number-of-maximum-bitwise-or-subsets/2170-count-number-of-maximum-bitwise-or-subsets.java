class Solution {
    private int countSubsets(int idx, int currOr, int[] nums, int maxOr, int [][] t){
        // base case
        if(idx == nums.length){
            if(currOr == maxOr){
                return 1; // found one subset
            }
            return 0;
        }
        if(t[idx][currOr] != -1) return t[idx][currOr];
        // Take nums[idx]
        int takeCount = countSubsets(idx+1, currOr | nums[idx], nums, maxOr, t);
        // Not taking nums[idx]
        int notTakeCount = countSubsets(idx+1, currOr, nums, maxOr, t);

        return takeCount + notTakeCount;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num : nums){
            maxOr |= num;
        }
        int n = nums.length;
        int [][] t = new int [n+1][maxOr+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }
        int currOr = 0;
        return countSubsets(0, currOr, nums, maxOr, t);
    }
}