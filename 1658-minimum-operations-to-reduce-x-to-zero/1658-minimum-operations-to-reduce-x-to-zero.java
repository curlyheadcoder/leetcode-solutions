class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is negative, reducing x is impossible
        if (target < 0) {
            return -1;
        }

        // We need to remove all elements
        if (target == 0) {
            return nums.length;
        }

        int left = 0;
        int windowSum = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            // Shrink window if sum exceeds target
            while (windowSum > target) {
                windowSum -= nums[left];
                left++;
            }

            // Found a valid subarray
            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // Minimum operations = elements outside longest subarray
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}