class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        // Step 1: Build frequency map for existing numbers
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            ans = Math.max(ans, freq.get(num)); // track the max frequency so far
        }
        // Step 2: Try every integer in range [min, max]
        for (int target = nums[0]; target <= nums[n - 1]; target++) {
            int left = lowerBound(nums, target - k);
            int right = upperBound(nums, target + k) - 1;

            int countInRange = right - left + 1;
            int baseFreq = freq.getOrDefault(target, 0);
            int possible = Math.min(countInRange, baseFreq + numOperations);
            ans = Math.max(ans, possible);
        }
        return ans;
    }
    // First index >= value
    private int lowerBound(int[] nums, int value) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < value)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    // First index > value
    private int upperBound(int[] nums, int value) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= value)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}