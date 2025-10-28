class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int result = 0;
        int currSum = 0;
        int S = 0;

        for (int num : nums) {
            S += num;
        }

        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            int left  = currSum;
            int right = S - left;

            if (nums[i] != 0) 
                continue;

            if (left == right)
                result += 2;
            else if (Math.abs(left - right) == 1)
                result++;
        }

        return result;
    }
}