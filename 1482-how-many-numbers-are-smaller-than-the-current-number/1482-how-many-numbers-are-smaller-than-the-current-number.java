class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // Since nums[i] in range [0, 100]
        for (int num : nums) {
            count[num]++;
        }
        // Modify count array to store cumulative counts of smaller numbers
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        return result;
    }
}
