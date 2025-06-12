class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        return IntStream.range(0, n)
                .map(i -> Math.abs(nums[i] - nums[(i+1) % n]))
                .max()
                .orElse(0);
    }
}