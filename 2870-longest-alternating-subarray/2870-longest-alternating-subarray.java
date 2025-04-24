class Solution {
    public int alternatingSubarray(int[] nums) {
        int maxLen = -1;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) continue;

            int len = 2;
            int expectedDiff = -1;

            for (int j = i + 2; j < n; j++) {
                int diff = nums[j] - nums[j - 1];
                if (diff == expectedDiff) {
                    len++;
                    expectedDiff *= -1;
                } else {
                    break;
                }
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
