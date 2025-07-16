class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int midEle = nums[(n/2)];
        int totalOps = 0;
        for(int i = 0; i < n; i++){
            totalOps += Math.abs(nums[i] - midEle);
        }
        return totalOps;
    }
}