class Solution {
    public int maxSum(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).filter(x -> x > 0).distinct().sum();
        return sum > 0 ? sum : max;
    }
}